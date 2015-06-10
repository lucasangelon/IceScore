package hockey.icescore.activities;


import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import hockey.icescore.OldClasses.*;
import hockey.icescore.OldClasses.Game;
import hockey.icescore.R;
import hockey.icescore.controllers.GoalieController;
import hockey.icescore.models.GoalieChange;

/**
 * Created by Suruchi 22-Mar-15.
 */

public class ChangeGoalie extends ActionBarActivity implements View.OnClickListener
{
    public static ListView listView1,listView2;
    public static ArrayAdapter<String> adapter;
    public static int homeTeamGoalieSelected=0,awayTeamGoalieSelected=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_goalie);

        //Home button is activated
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Screen handling show Actionbar title.
        getSupportActionBar().setTitle("Change Goalie");

        //
        Button changeHomeTeamGoalie = (Button) findViewById(R.id.button2);
        changeHomeTeamGoalie.setOnClickListener(this);

        Button changeAwayTeamGoalie = (Button) findViewById(R.id.button3);
        changeAwayTeamGoalie.setOnClickListener(this);
        //Home Team Change Goalie

        listView1= (ListView) findViewById(R.id.listView);

        ArrayAdapter<Player> homeTeamAdapter = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                Game.homeTeam.players );


        listView1.setAdapter(homeTeamAdapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
               homeTeamGoalieSelected = position;
            }
        });

        //Away Team Golie Change
        listView2= (ListView) findViewById(R.id.listView2);
        ArrayAdapter<Player> awayTeamAdapter = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                Game.awayTeam.players );
        listView2.setAdapter(awayTeamAdapter);
        listView2.smoothScrollToPosition(awayTeamGoalieSelected);
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                awayTeamGoalieSelected = position;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_general, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button2://Home Team Change
                Player goalie = Game.homeTeam.getPlayer(homeTeamGoalieSelected);
                //Setting the team goalie
                Game.homeTeam.addGoalie(goalie.getID(), goalie.name, goalie.getNumber());

                //Adding to the database
                GoalieController gc = new GoalieController(getBaseContext());
                GoalieChange ObjGC = new GoalieChange(goalie.playerID,Game.gameID,Game.homeTeam.getTeamID(),Game.gameTime);
                gc.changeGoalie(ObjGC,goalie.name,Game.homeTeam.getName(),goalie.getNumber());
                break;

            case R.id.button3://Away Team Change
                goalie = Game.homeTeam.getPlayer(awayTeamGoalieSelected);
                //Setting the team goalie
                Game.awayTeam.addGoalie(goalie.getID(), goalie.name, goalie.getNumber());

                //Adding to the database
                gc = new GoalieController(getBaseContext());
                ObjGC = new GoalieChange(goalie.playerID,Game.gameID,Game.awayTeam.getTeamID(),Game.gameTime);
                gc.changeGoalie(ObjGC,goalie.name,Game.awayTeam.getName(),goalie.getNumber());
                break;
        }

    }

}
