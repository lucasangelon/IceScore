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
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import hockey.icescore.OldClasses.*;
import hockey.icescore.OldClasses.Game;
import hockey.icescore.R;
import hockey.icescore.controllers.ActionController;
import hockey.icescore.fragments.PlayerListRight;
import hockey.icescore.models.GamePersonAction;
import hockey.icescore.models.GamePersonActionExtended;
import hockey.icescore.util.Constants;
import hockey.icescore.util.Fragment_Listener;

import static hockey.icescore.OldClasses.Game.homeTeam;


public class Penalty extends ActionBarActivity implements Fragment_Listener, View.OnClickListener,AdapterView.OnItemClickListener{
    ListView penType2;
    int selected = 0;
    String pen = "Fix this later";
    public static ArrayList<String> spares = new ArrayList<String>();
    public static ArrayList<ArrayList<String>> penals = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> penaltyLog = new ArrayList<String>();
    ArrayList<String> temp = new ArrayList<String>();
    Penalty p = this;
    String playernum = "";
    Team selectedTeam = Game.homeTeam;
    Spinner occuredAt;
    Spinner penaltyTime;
    ListView loglog;
    ArrayList<tempPenalty> tba = new ArrayList<tempPenalty>();
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
    private String format(int tt){
        DecimalFormat df = new DecimalFormat("00");
        return df.format(tt);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        spares = new ArrayList<>();
        penals = new ArrayList<ArrayList<String>>();
        temp = new ArrayList<>();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalty);

        occuredAt = (Spinner) findViewById(R.id.spinnerPenaltyOccurred);
        penaltyTime = (Spinner) findViewById(R.id.spinnerTimePenalised);
        ArrayList<String> oc = new ArrayList<String>();
        int timerTime = (Game.periodLength*60)-Game.gameTimeInt;
        loglog = (ListView)findViewById(R.id.listViewPenaltyLog);
        for(int i = -30;i<=30;i++)
        {
            int hours = (timerTime+i) / 3600, remainder = (timerTime+i) % 3600, minutes = remainder / 60, seconds = remainder % 60;
            oc.add(format(minutes) + ":" + format(seconds));
        }
        ArrayAdapter<String> spinAd = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_spinner_item,
                oc );
        occuredAt.setAdapter(spinAd);
        occuredAt.setSelection(30);

        //Attaches buttons to onClick listeners
        Button teamA = (Button) findViewById(R.id.btnTeamA);
        teamA.setOnClickListener(this);

        Button teamB = (Button) findViewById(R.id.btnTeamB);
        teamB.setOnClickListener(this);

        Button addPenalty = (Button) findViewById(R.id.btnAddPenalty);
        addPenalty.setOnClickListener(this);

        Button clearPenalty = (Button) findViewById(R.id.btnClearSelectedPenalties);
        clearPenalty.setOnClickListener(this);

        Button confirmPenalty = (Button) findViewById(R.id.btnConfirmPenalties);
        confirmPenalty.setOnClickListener(this);



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
        penType2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                pen = penType2.getAdapter().getItem(position).toString();
                setCurrent();
            }
        });


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

        spares.add("Minor Penalties >");
        spares.add("Major Penalties >");
        spares.add("Misconduct >");
        spares.add("Game Misconduct >");
        spares.add("Match Penalty >");

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
            // displays team a fragment
            case R.id.btnTeamA:
                addFragment(hockey.icescore.OldClasses.Game.homeTeam);
                selectedTeam=Game.homeTeam;
                break;
            // displays team b fragment
            case R.id.btnTeamB:
                addFragment(hockey.icescore.OldClasses.Game.awayTeam);
                selectedTeam=Game.awayTeam;
                break;

            // adds penalty (only with correct parameters) to the list
            case R.id.btnAddPenalty:
                try {
                    String t = selectedTeam.getPlayerByNumber(Integer.parseInt(playernum)) +
                            " at: " + occuredAt.getSelectedItem().toString() +
                            " for " + pen +
                            " | penalty time out : " + penaltyTime.getSelectedItem().toString();
                    penaltyLog.add(t);
                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                            this,
                            android.R.layout.simple_list_item_1,
                            penaltyLog);
                    loglog.setAdapter(arrayAdapter);
                    GamePersonAction gpat = new GamePersonAction(
                            hockey.icescore.OldClasses.Game.homeTeam.getPlayerByNumber(Integer.parseInt(playernum)).getID(),
                            Constants.ACTION_GOAL_ID, hockey.icescore.OldClasses.Game.homeTeam.getTeamID(),
                            Game.currentPeriod, hockey.icescore.OldClasses.Game.gameID, Game.gameTime);

                    GamePersonActionExtended gpaet = new GamePersonActionExtended(1, 0, "");
                    tempPenalty temp = new tempPenalty(gpat, gpaet, Integer.parseInt(playernum), selectedTeam.getTeamName(), t);
                    tba.add(temp);
                    break;
                }catch (Exception e)
                {
                    e.printStackTrace();
                    displayExceptionMessage(e.getMessage());
                }

                //clear selected penalties from list
            case R.id.btnClearSelectedPenalties:
                try {

                    penaltyLog = new ArrayList<String>();
                    ArrayAdapter<String> aa = new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_list_item_1,
                        penaltyLog);
                    loglog.setAdapter(aa);
                    tba = new ArrayList<>();
                    break;
                }catch (Exception e)
                {
                    e.printStackTrace();
                    displayExceptionMessage(e.getMessage());
                }

                //insert penalties into game log
            case R.id.btnConfirmPenalties:
                try {
                    ActionController actionMan;
                    actionMan = new ActionController(this);
                    for (tempPenalty te : tba) {
                        actionMan.insertPenaltyInjury(te.gpa, te.gpae, te.playerNum, te.teamName, te.desc);
                    }

                    break;
                }catch (Exception e)
                {
                    e.printStackTrace();
                    displayExceptionMessage(e.getMessage());
                }

        }
    }

    @Override
    public void buttonClicked(String val) {
        playernum=val;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }




    // Storing penalties temporarily until confirm button is clicked
    private class tempPenalty
    {
        GamePersonAction gpa;
        GamePersonActionExtended gpae;
        int playerNum;
        String teamName;
        String desc;
        tempPenalty(GamePersonAction gpa,GamePersonActionExtended gpae,int playerNum,String teamName,String desc)
        {
            this.gpa = gpa;
            this.gpae = gpae;
            this.playerNum=playerNum;
            this.teamName=teamName;
            this.desc=desc;

        }


    }

    // Displays error message for the common errors on this page

    public void displayExceptionMessage(String msg) //Josh
    {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



}
