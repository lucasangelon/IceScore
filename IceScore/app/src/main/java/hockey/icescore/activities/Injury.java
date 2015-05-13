package hockey.icescore.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import hockey.icescore.OldClasses.Player;
import hockey.icescore.OldClasses.Team;
import hockey.icescore.R;
import hockey.icescore.controllers.ActionController;
import hockey.icescore.fragments.PlayerListRight;
import hockey.icescore.models.GamePersonAction;
import hockey.icescore.models.GamePersonActionExtended;
import hockey.icescore.models.GamePersonActionGoal;
import hockey.icescore.util.Constants;
import hockey.icescore.util.Fragment_Listener;
import hockey.icescore.OldClasses.Game;

/**
 * Created by Lucas Angelon on 21-Mar-15.
 */
public class Injury extends ActionBarActivity implements Fragment_Listener, View.OnClickListener {
    Team currentTeam;
    TextView playerNum;
    TextView playerName;
    TextView desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_injury);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        playerNum = (TextView) findViewById(R.id.PlayerNum);
        playerName = (TextView) findViewById(R.id.Player_name);
        desc = (EditText) findViewById(R.id.descText);

        Button teamA = (Button) findViewById(R.id.teamA);
        teamA.setOnClickListener(this);

        Button teamB = (Button) findViewById(R.id.teamB);
        teamB.setOnClickListener(this);

    }

    public void addFragment(Team team){
        PlayerListRight p = new PlayerListRight();
        p.setListener(this);
        p.setTeam(team);
        android.app.FragmentManager manager=getFragmentManager();
        android.app.FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.container, p, "");
        transaction.commit();

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
    public void buttonClicked(String val) {
        Toast toast = Toast.makeText(this, "what "+val, Toast.LENGTH_SHORT);
        toast.show();
        Player player = currentTeam.getPlayerByNumber(Integer.parseInt(val));
        System.out.println(player.name);
        String name = player.name;
        playerNum.setText(val);
        playerName.setText(name);
        //InsertIntoDb(new Injury(currentTeam, Game.currentPeriod, name, desc.gtText()));
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.teamA:
                addFragment(Game.homeTeam);
                currentTeam=Game.homeTeam;

                break;
            case R.id.teamB:
                addFragment(Game.awayTeam);
                currentTeam=Game.awayTeam;
                break;
            case R.id.button_confirm:
                int playernum = Integer.parseInt(playerNum.getText().toString());
                ActionController actionMan;
                actionMan = new ActionController(this);
                GamePersonAction gpa = new GamePersonAction(
                        hockey.icescore.OldClasses.Game.homeTeam.getPlayerByNumber(playernum).getID(),
                        Constants.ACTION_GOAL_ID, hockey.icescore.OldClasses.Game.homeTeam.getTeamID(),
                        Game.currentPeriod, hockey.icescore.OldClasses.Game.gameID, Game.gameTime);



                GamePersonActionExtended gpae = new GamePersonActionExtended(0,1,"");


                actionMan.insertPenaltyInjury(gpa,gpae,playernum,currentTeam.getTeamName(),desc.getText().toString());
        }
    }
}
