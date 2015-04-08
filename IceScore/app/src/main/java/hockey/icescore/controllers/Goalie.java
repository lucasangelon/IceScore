package hockey.icescore.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import hockey.icescore.OldClasses.Game;
import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.GoalieChange;
import hockey.icescore.models.Timeout;
import hockey.icescore.util.Constants;

/**
 * Created by Josh on 7/04/2015.
 */
public class Goalie
{
    private DatabaseManager dbManager;
    private Context context;

        // Constructor
        public Goalie(Context context)
        {
            this.context = context;
            dbManager = DatabaseManager.getInstance(context);
        }

        //TODO insert Game_Team_Goalie stuff
// will we need player number as well?
    public String changeGoalie(String player, String teamName, int playerNumber)
    {
       long returnId = -1;
        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler
        try
        {
          // Adding the values from the Goalie object
            ContentValues values = new ContentValues();
            values.put(Constants.FK_PERSON_ID, GoalieChange.getPersonId());
            values.put(Constants.FK_GAME_ID, GoalieChange.getGameId());
            values.put(Constants.FK_TEAM_ID, GoalieChange.getTeamId());
            values.put(Constants.FIELD_TIMESTAMP, GoalieChange.getTimestamp());

            //Inserting the data into the table
            returnId = sqlDb.insert(Constants.TABLE_GAME_TEAM_GOALIE, null, values);

            //Finalizing the transaction
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Error message.
            sqlException.printStackTrace();
            return "ERROR 3: Unable to insert Goalie into database.";
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        // Succesfully inserted notice
        return  player + " " + playerNumber + " became goalie on " + teamName + Game.gameTimer.formatNice();

        // Errors Abound, getters and setters from model GoalieChange can't be found

    }



}
