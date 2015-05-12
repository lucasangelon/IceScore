package hockey.icescore.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.GamePeriod;
import hockey.icescore.models.Timeout;
import hockey.icescore.util.Constants;

/**
 * Created by Josh on 7/04/2015.
 */
public class TimerController {

    private DatabaseManager dbManager;
    private Context context;

    // Constructor
    public TimerController(Context context)
    {
        this.context = context;
        dbManager = DatabaseManager.getInstance(context);
    }
    // method to insert a Timeout
    public String timeout(Timeout to, String teamName)
    {
        long returnId = -1;
        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler.
        try
        {
            //Adding the values from the Timeout object
            ContentValues values = new ContentValues();
            values.put(Constants.FK_TEAM_ID, to.getTeamId());
            values.put(Constants.FK_GAME_ID, to.getGameId());
            values.put(Constants.FIELD_TIMESTAMP, to.getTimestamp());

            //Inserting the data into the table
            returnId = sqlDb.insert(Constants.TABLE_TIMEOUT, null, values);

            // Finalizing the transaction.
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Error message.
            sqlException.printStackTrace();
            return "ERROR 4: Unable to insert Timeout into database.";
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        //Succesfully inserted notice
        return to.getTimestamp() + " Timeout called by " + teamName;
    }



    public String period(GamePeriod gp)
    {
        long returnId = -1;
        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler
        try
        {
           //Adding the values from the GamePeriod object
            ContentValues values = new ContentValues();
            values.put(Constants.FK_GAME_ID, gp.getGameId());
            values.put(Constants.FK_PERIOD_ID, gp.getPeriodId());
            values.put(Constants.FIELD_TIMESTAMP, gp.getTimestamp());
            values.put(Constants.FIELD_DEFAULT_TIME, gp.getPeriodLength());

            //Inserting the data into the table
            returnId = sqlDb.insert(Constants.TABLE_GAME_PERIOD, null, values);

            //Finalizing the transaction
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Error message.
            sqlException.printStackTrace();
            return "ERROR 5: Unable to insert Period length into database.";
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        //Successfully inserted notice
        return "Period length is " + gp.getPeriodLength();
    }

}
