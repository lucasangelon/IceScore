package hockey.icescore.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.Log;
import hockey.icescore.models.SignOff;
import hockey.icescore.util.Constants;

/**
 * Created by Josh on 12/05/2015.
 */
public class SignatureController {
    private DatabaseManager dbManager;
    private Context context;

    // Constructor
    public SignatureController(Context context)
    {
        this.context = context;
        dbManager = DatabaseManager.getInstance(context);
    }

    public synchronized void insertSignature(SignOff so)
    {
        // Retrieve the writable database and start a transaction.
        SQLiteDatabase sqlDb = dbManager.getWritableDatabase();
        sqlDb.beginTransaction();

        // Error Handler.
        try
        {
            // Compressing the bitmap to a byte array in order to store it
            // in the local / server database.
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            so.getSignature().compress(Bitmap.CompressFormat.PNG, 100, bos);
            byte[] bArray = bos.toByteArray();

            // Adding the values from the GPA object.
            ContentValues values = new ContentValues();
            values.put(Constants.FIELD_SIGNATURE, bArray);
            values.put(Constants.FK_GAME_ID, so.getGameId());
            values.put(Constants.FK_PERSON_ID, so.getPersonId());

            // Inserting the data into the table.
            sqlDb.insert(Constants.TABLE_SIGN_OFF, null, values);

            // Finalizing the transaction.
            sqlDb.setTransactionSuccessful();
        }
        catch (SQLiteException sqlException)
        {
            // Return an error string.
            sqlException.printStackTrace();
        }
        finally
        {
            // Close the object.
            sqlDb.endTransaction();
            sqlDb.close();
        }
    }
}
