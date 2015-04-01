package hockey.icescore.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import hockey.icescore.util.Constants;

/**
 * Created by Lucas Angelon on 25-Mar-15.
 */

// Class to call and start/updated the database - Lucas.
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
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_ROLE);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_IDENTIFIER);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_ROLE_IDENTIFIER);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_PERSON);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_DIVISION);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_TEAM);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_TEAM_PERSON_NUMBER);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_PERIOD);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_VENUE);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_GAME);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_GAME_NOTE);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_GAME_PERIOD);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_GAME_TEAM_GOALIE);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_SIGN_OFF);
        sqlDb.execSQL(Constants.DatabaseGenerator.CREATE_TABLE_TIMEOUT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqlDb, int oldVersion, int newVersion)
    {
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_ROLE);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_IDENTIFIER);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_ROLE_IDENTIFIER);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_PERSON);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_DIVISION);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_TEAM);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_TEAM_PERSON_NUMBER);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_PERIOD);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_VENUE);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_GAME);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_GAME_NOTE);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_GAME_PERIOD);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_GAME_TEAM_GOALIE);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_SIGN_OFF);
        sqlDb.execSQL(Constants.RECREATE_TABLE + Constants.TABLE_TIMEOUT);

    }
}
