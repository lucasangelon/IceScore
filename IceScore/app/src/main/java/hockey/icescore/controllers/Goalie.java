package hockey.icescore.controllers;

import android.content.Context;

import hockey.icescore.OldClasses.Game;
import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.models.Timeout;

/**
 * Created by 041402463 on 7/04/2015.
 */
public class Goalie {



        private DatabaseManager dbManager;
        private Context context;

        // Constructor
        public Goalie(Context context)
        {
            this.context = context;
            dbManager = DatabaseManager.getInstance(context);
        }

        //TODO insert Game_Team_Goalie stuff

    public String changeGoalie(String player, String teamName){
        //TODO insert Game_Team_Goalie, also do models
        //insertIntoDB(xyz)
       // return player+" became goalie on "+teamName+ Game.gameTimer.formatNice();
        //return is my correct gamelog sql statement
        return "TODO";
    }

}
