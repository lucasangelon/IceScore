package hockey.icescore.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import hockey.icescore.OldClasses.*;
import hockey.icescore.R;
import hockey.icescore.fragments.PlayerListRight;
import hockey.icescore.util.Fragment_Listener;

import static hockey.icescore.OldClasses.Game.homeTeam;


public class Penalty extends ActionBarActivity implements Fragment_Listener, View.OnClickListener,AdapterView.OnItemClickListener{
    ListView penType2;
    int selected = 0;
    public static ArrayList<String> spares = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> penals = new ArrayList<ArrayList<String>>();
    ArrayList<String> temp = new ArrayList<String>();
    Penalty p = this;

    public void addFragment(Team team){
        PlayerListRight p1 = new PlayerListRight();
        p1.setListener(this);
        p1.setTeam(team);

        android.app.FragmentManager manager1 = getFragmentManager();
        android.app.FragmentTransaction transaction1 = manager1.beginTransaction();
        transaction1.add(R.id.non_offensive, p1, "right frag");

        transaction1.commit();

    }
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalty);

        Button teamA = (Button) findViewById(R.id.btnTeamA);
        teamA.setOnClickListener(this);

        Button teamB = (Button) findViewById(R.id.btnTeamB);
        teamB.setOnClickListener(this);

        edit = (EditText) findViewById(R.id.editTextPenaltySearch);
        edit.addTextChangedListener(new TextWatcher() {
            ArrayList<Player> temp;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }
            //Start of the search penalty function
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(edit.getText().toString().trim().equals(""))
                {
                    setCurrent();
                } else {
                    ArrayList<String> tempo = new ArrayList<String>();
                    for (ArrayList<String> f : penals) {
                        int i = 0;
                        while (i < f.size()) {
                            if (f.get(i).contains(edit.getText().toString().trim()))
                                tempo.add(f.get(i));
                            i++;
                        }
                    }
                    ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
                            p,
                            android.R.layout.simple_list_item_1,
                            tempo);
                    penType2.setAdapter(arrayAdapter2);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ListView penType = (ListView) findViewById(R.id.listViewCategory);
        penType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                selected = position;
                setCurrent();
            }
        });

        penType2 = (ListView) findViewById(R.id.listViewPenalty);



       /*                 ActionController actionMan;
                actionMan = new ActionController(this);
                GamePersonAction gpa = new GamePersonAction(
                        hockey.icescore.OldClasses.Game.homeTeam.getPlayerByNumber(playernum).getID(),
                        Constants.ACTION_GOAL_ID, hockey.icescore.OldClasses.Game.homeTeam.getTeamID(),
                        Game.currentPeriod, hockey.icescore.OldClasses.Game.gameID, Game.gameTime);



                GamePersonActionExtended gpae = new GamePersonActionExtended(0,1,"");


                actionMan.insertPenaltyInjury(gpa,gpae,playernum,currentTeam.getTeamName(),desc.getText().toString());
        */

        // Temporary arrays for the penalty section - Josh
        // all lists belong to the temp categories section (which is under this)
        // For testing purposes only, more thorough penalty section will be in final...
        // And that data won't be in this file

        temp.add("charging");
        temp.add("clipping");
        temp.add("hooking");
        temp.add("slashing");
        temp.add("tripping");
        penals.add(temp);
        temp = new ArrayList<String>();

        temp.add("butt-ending");
        temp.add("elbowing");
        temp.add("fighting");
        temp.add("illegal check to the head");
        temp.add("spearing");
        penals.add(temp);
        temp = new ArrayList<String>();

        temp.add("Banging boards with stick in protest of an official’s ruling");
        temp.add("inciting an opponent");
        temp.add("instigating a fight");
        temp.add("leaving bench to speak to official");
        temp.add("verbal abuse of an official");
        penals.add(temp);
        temp = new ArrayList<String>();

        temp.add("attempt to injure");
        temp.add("biting");
        temp.add("hair pulling");
        temp.add("kicking a player");
        temp.add("throwing stick or any object");
        penals.add(temp);
        temp = new ArrayList<String>();

        temp.add("continues or attempts to continue a fight");
        temp.add("obscene gestures");
        temp.add("physically abuses an official");
        temp.add("interfering with or striking a spectator");
        temp.add("racial taunts or slurs");
        penals.add(temp);



        //temp Array categories (0-4)

        spares.add("Minor Penalties");
        spares.add("Major Penalties");
        spares.add("Misconduct");
        spares.add("Game Misconduct");
        spares.add("Match Penalty");

        //populates ListViewCategory
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                spares );
        penType.setAdapter(arrayAdapter);

        setCurrent();

    }

    //Updates listViewPenalty to show current selection
    public void setCurrent()
    {
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                penals.get(selected));
        penType2.setAdapter(arrayAdapter2);
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

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.btnTeamA:
                addFragment(hockey.icescore.OldClasses.Game.homeTeam);

                break;
            case R.id.btnTeamB:
                addFragment(hockey.icescore.OldClasses.Game.awayTeam);
                break;
        }
    }

    @Override
    public void buttonClicked(String val) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
