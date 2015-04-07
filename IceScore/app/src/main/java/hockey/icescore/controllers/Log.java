package hockey.icescore.controllers;

import android.content.Context;

import hockey.icescore.helper.DatabaseManager;

/**
 * Created by Lucas Angelon on 07-Apr-15.
 */
public class Log
{
    private DatabaseManager dbManager;
    private Context context;

    public Log (Context context)
    {
        this.context = context;
        dbManager = dbManager.getInstance(context);
    }
}
