package hockey.icescore.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import hockey.icescore.util.Constants;

/**
 * Created by Lucas Angelon on 25-Mar-15.
 */
public class DatabaseManager extends SQLiteOpenHelper
{
    private static DatabaseManager dbManager;

    public static synchronized DatabaseManager getInstance(Context con)
    {
        if (dbManager == null)
        {
            dbManager = new DatabaseManager(con.getApplicationContext());
        }

        return dbManager;
    }

    private DatabaseManager (Context con)
    {
        super(con, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqlDb)
    {
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_PERSON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDb, int oldVersion, int newVersion)
    {
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_PERSON);
    }
}
