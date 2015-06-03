package hockey.icescore.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import hockey.icescore.OldClasses.Game;
import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.GamePersonAction;
import hockey.icescore.models.GamePersonActionExtended;
import hockey.icescore.models.GamePersonActionGoal;
import hockey.icescore.models.Log;
import hockey.icescore.util.Constants;

/**
 * Created by Suruchi on 03-June-15.
 */
public class LogController {
    private DatabaseManager dbManager;
    private Context context;

    public LogController(Context context) {
        this.context = context;
        dbManager = dbManager.getInstance(context);
    }

    // Method to Delete Shots/Saves,Penalties,Injuries and Goals
    public synchronized boolean deleteAction(long rowId, int actionID) {
        long returnId = -1;

        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler.
        try {

            if (actionID != Constants.ACTION_SHOTSAVE_ID) {

                if (actionID == Constants.ACTION_INJURY_ID || actionID == Constants.ACTION_PENALTY_ID) {
                    // Deleting the extra action into the database.
                    returnId = sqlDb.delete(Constants.TABLE_GAME_PERSON_ACTION_EXTENDED, Constants.FK_GAME_PERSON_ACTION_ID + "=" + rowId, null);
                }
                else if (actionID == Constants.ACTION_GOAL_ID){
                    // Deleting the extra action into the database.
                    returnId = sqlDb.delete(Constants.TABLE_GAME_PERSON_ACTION_GOAL, Constants.FK_GAME_PERSON_ACTION_ID + "=" + rowId, null);
                }
            }

            // Deleting depending upon the row_id
            returnId = sqlDb.delete(Constants.TABLE_GAME_PERSON_ACTION, Constants.FIELD_ID + "=" + rowId, null);

            // Finalizing the transaction.
            sqlDb.setTransactionSuccessful();

        } catch (SQLiteException sqlException) {
            // Return an error status.
            sqlException.printStackTrace();
            return false;
        } finally {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        // Return the status of deleting
        return returnId > 0;
    }
}

