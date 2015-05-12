package hockey.icescore.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import hockey.icescore.R;


public class Penalty extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalty);

        /*
                        ActionController actionMan;
                actionMan = new ActionController(this);
                GamePersonAction gpa = new GamePersonAction(
                        hockey.icescore.OldClasses.Game.homeTeam.getPlayerByNumber(playernum).getID(),
                        Constants.ACTION_GOAL_ID, hockey.icescore.OldClasses.Game.homeTeam.getTeamID(),
                        Game.currentPeriod, hockey.icescore.OldClasses.Game.gameID, Game.gameTime);



                GamePersonActionExtended gpae = new GamePersonActionExtended(0,1,"");


                actionMan.insertPenaltyInjury(gpa,gpae,playernum,currentTeam.getTeamName(),desc.getText().toString());
         */
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_penalty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
