package hockey.icescore.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.GamePersonAction;
import hockey.icescore.util.Constants;

/**
 * Created by Lucas Angelon on 01-Apr-15.
 */
public class Action
{
    private DatabaseManager dbManager;
    private Context context;

    // Constructor
    public Action(Context context)
    {
        this.context = context;
        dbManager = DatabaseManager.getInstance(context);
    }

    // Method to insert Shots, Goals and Assists - Lucas
    public String action(GamePersonAction gpa, int playerNumber, String actionTitle, String teamName)
    {
        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler.
        try
        {
            // Adding the values from the GPA object.
            ContentValues values = new ContentValues();
            values.put(Constants.FK_PERSON_ID, gpa.getPeriodId());
            values.put(Constants.FK_ACTION_ID, gpa.getActionId());
            values.put(Constants.FK_TEAM_ID, gpa.getTeamId());
            values.put(Constants.FK_PERIOD_ID, gpa.getPeriodId());
            values.put(Constants.FK_GAME_ID, gpa.getGameId());
            values.put(Constants.FIELD_TIMESTAMP, gpa.getTimestamp());

            // Inserting the data into the table.
            sqlDb.insert(Constants.TABLE_GAME_PERSON_ACTION, null, values);

            // Finalizing the transaction.
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Error message.
            sqlException.printStackTrace();
            return "ERROR 1: Unable to insert action into database.";
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        // Successfully inserted notice.
        return "Time: " + gpa.getTimestamp() + ", Action: " + actionTitle + ", Team: " + teamName + ", Player: " + playerNumber;

        //TODO CREATE A LOG OBJECT FOR THE GAMELOG WITH THE AFOREMENTIONED STRING, THE PLAYER ID AND THE TABLE NAME.
    }

    // Method to insert Penalties and Injuries - Lucas
    public String actionExtended(GamePersonAction gpa, int playerNumber, String actionTitle, String teamName, int extendedActionId, String notes)
    {
        // Declaring the extendedActionId holders.
        int penaltyId = 0;
        int injuryId = 0;

        // If the action is not a penalty or an injury, return an error message.
        if (gpa.getActionId() != 4 & gpa.getActionId() != 5)
        {
            return "ERROR 2: Invalid Action (Penalty / Injury) Detected.";
        }
        else if (gpa.getActionId() == 4)
        {
            penaltyId = extendedActionId;
        }
        else if (gpa.getActionId() == 5)
        {
            injuryId = extendedActionId;
        }


        // Insert the base penalty/injury action into a table.
        String actionLog = action(gpa, playerNumber, actionTitle, teamName);

        // Retrieve the ID from the aforementioned entry.
        String retrieveId = "SELECT ID FROM GAME_PERSON_ACTION " +
                "WHERE TIMESTAMP = " + gpa.getTimestamp();
        int retrievedId = 0;

        String extendedAction = "INSERT INTO GAME_PERSON_ACTION_EXTENDED " +
                "VALUES("
                + retrievedId + ", "
                + penaltyId + ", "
                + injuryId + ", "
                + notes +
                ")";

        return "Action Successfully saved!";
    }
}
