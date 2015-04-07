package hockey.icescore.controllers;

import android.content.Context;

import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.GamePeriod;
import hockey.icescore.models.Timeout;

/**
 * Created by 041402463 on 7/04/2015.
 */
public class Timer {

    private DatabaseManager dbManager;
    private Context context;

    // Constructor
    public Timer(Context context)
    {
        this.context = context;
        dbManager = DatabaseManager.getInstance(context);
    }

    public String timeout(Timeout to, String teamName){
        //TODO insert Game_Period table, also do models
        return null;
    }



    public String period(GamePeriod gp){
        //TODO insert Timeout Table, also do models
        return null;
    }

}
