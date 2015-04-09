package hockey.icescore.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.*;
import hockey.icescore.util.Constants;

/**
 * Created by Lucas Angelon on 01-Apr-15.
 */
public class ActionController
{
    private DatabaseManager dbManager;
    private Context context;

    // Constructor
    public ActionController(Context context)
    {
        this.context = context;
        dbManager = DatabaseManager.getInstance(context);
    }

    // Method to insert Shots/Saves - Lucas
    public synchronized String insertShotSave(GamePersonAction gpa)
    {
        long returnId = -1;

        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler.
        try
        {
            // Adding the values from the GPA object.
            ContentValues values = new ContentValues();
            values.put(Constants.FK_PERSON_ID, gpa.getPersonId());
            values.put(Constants.FK_ACTION_ID, gpa.getActionId());
            values.put(Constants.FK_TEAM_ID, gpa.getTeamId());
            values.put(Constants.FK_PERIOD_ID, gpa.getPeriodId());
            values.put(Constants.FK_GAME_ID, gpa.getGameId());
            values.put(Constants.FIELD_TIMESTAMP, gpa.getTimestamp());

            // Inserting the data into the table.
            returnId = sqlDb.insert(Constants.TABLE_GAME_PERSON_ACTION, null, values);

            // Finalizing the transaction.
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Return an error string.
            sqlException.printStackTrace();
            return "ERROR 1: Unable to insert shot into database.";
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        // Successfully inserted notice.
        return "Shot successfully saved!";
    }

    // Method to insert Penalties and Injuries - Lucas
    public synchronized Log insertPenaltyInjury(GamePersonAction gpa, int playerNumber,
                                                String teamName, int specificId,
                                                String specificName, String notes)
    {
        int penaltyId = 0;
        int injuryId = 0;
        long returnId = -1;
        boolean isPenalty = false;

        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler.
        try
        {
            // Check if the action is a penalty or an injury.
            if (gpa.getActionId() == Constants.ACTION_PENALTY_ID)
            {
                penaltyId = specificId;
                isPenalty = true;
            }
            else
            {
                injuryId = specificId;
            }

            // Adding the values from the GPA object.
            ContentValues values = new ContentValues();
            values.put(Constants.FK_PERSON_ID, gpa.getPersonId());
            values.put(Constants.FK_ACTION_ID, gpa.getActionId());
            values.put(Constants.FK_TEAM_ID, gpa.getTeamId());
            values.put(Constants.FK_PERIOD_ID, gpa.getPeriodId());
            values.put(Constants.FK_GAME_ID, gpa.getGameId());
            values.put(Constants.FIELD_TIMESTAMP, gpa.getTimestamp());

            // Inserting the data into the table.
            returnId = sqlDb.insert(Constants.TABLE_GAME_PERSON_ACTION, null, values);

            // Adding the extra action values.
            values = new ContentValues();
            values.put(Constants.FK_GAME_PERSON_ACTION_ID, returnId);
            values.put(Constants.FK_PENALTY_ID, penaltyId);
            values.put(Constants.FK_INJURY_ID, injuryId);
            values.put(Constants.FIELD_NOTES, notes);

            // Inserting the extra action into the database.
            sqlDb.insert(Constants.TABLE_GAME_PERSON_ACTION_EXTENDED, null, values);

            // Finalizing the transaction.
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Return a null log for error processing..
            sqlException.printStackTrace();
            return new Log();
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        Log.Penalty lp;
        Log.Injury li;

        // Create a penalty/injury log object for the game log.
        if (isPenalty)
        {
            lp = new Log(). new Penalty(returnId, Integer.toString(playerNumber), teamName,
                    gpa.getTimestamp(), specificName);
            return lp;
        }
        else
        {
            li = new Log(). new Injury(returnId, Integer.toString(playerNumber), teamName,
                    gpa.getTimestamp(), specificName);
            return li;
        }
    }

    // Method to insert Penalties and Injuries - Lucas
    public synchronized Log insertGoal(GamePersonAction gpa, GamePersonActionGoal gpag,
                                       int playerNumber, String teamName, String assistNumber,
                                       String assist2Number)
    {
        long returnId = -1;

        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler.
        try
        {
            // Adding the values from the GPA object.
            ContentValues values = new ContentValues();
            values.put(Constants.FK_PERSON_ID, gpa.getPersonId());
            values.put(Constants.FK_ACTION_ID, gpa.getActionId());
            values.put(Constants.FK_TEAM_ID, gpa.getTeamId());
            values.put(Constants.FK_PERIOD_ID, gpa.getPeriodId());
            values.put(Constants.FK_GAME_ID, gpa.getGameId());
            values.put(Constants.FIELD_TIMESTAMP, gpa.getTimestamp());

            // Inserting the data into the table.
            returnId = sqlDb.insert(Constants.TABLE_GAME_PERSON_ACTION, null, values);

            // Adding the extra action values.
            values = new ContentValues();
            values.put(Constants.FK_GAME_PERSON_ACTION_ID, returnId);
            values.put(Constants.FK_GOALIE_ID, gpag.getGoalieId());
            values.put(Constants.FK_ASSIST_ID, gpag.getAssistId());
            values.put(Constants.FK_ASSIST2_ID, gpag.getAssist2Id());

            // Inserting the extra action into the database.
            sqlDb.insert(Constants.TABLE_GAME_PERSON_ACTION_GOAL, null, values);

            // Finalizing the transaction.
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Return a null log for error processing..
            sqlException.printStackTrace();
            return new Log();
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }

        // Create a penalty/injury log object for the game log.
        Log.Goal l = new Log(). new Goal(returnId, Integer.toString(playerNumber), teamName, gpa.getTimestamp(),
                assistNumber, assist2Number);

        return l;
    }
}
