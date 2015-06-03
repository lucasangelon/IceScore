package hockey.icescore.controllers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import hockey.icescore.helper.DatabaseManager;

/**
 * Created by Lucas Angelon on 07-Apr-15.
 */
public class LogController
{
    private DatabaseManager dbManager;
    private Context context;

    public LogController(Context context)
    {
        this.context = context;
        dbManager = dbManager.getInstance(context);
    }
}
