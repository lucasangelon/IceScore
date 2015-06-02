package hockey.icescore.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;
import static hockey.icescore.OldClasses.Game.*;
import hockey.icescore.OldClasses.*;
import hockey.icescore.R;
import hockey.icescore.controllers.ActionController;
import hockey.icescore.controllers.TimerController;
import hockey.icescore.fragments.PlayerListLeft;
import hockey.icescore.fragments.PlayerListRight;
import hockey.icescore.models.GamePersonAction;
import hockey.icescore.models.GamePersonActionGoal;
import hockey.icescore.models.Timeout;
import hockey.icescore.util.Constants;
import hockey.icescore.util.Fragment_Listener;

// everything done by jack
//dont edit
public class Game extends ActionBarActivity implements View.OnClickListener , Fragment_Listener
{
    Context gameContext = this;
    ActionController actionController;
    TimerController timerController;
    static Timer t;

    String txt = "whoop whoop";
    String awayAssists = "";
    String homeAssists = "";
    String homeAssist = "";
    String homeAssist2 = "";
    String awayAssist = "";
    String awayAssist2 = "";
    String homeGoalieNumber = "";
    String awayGoalieNumber = "";

    boolean ticking = false;
    boolean homeTicking = false;
    boolean awayTicking = false;

    TextView txtTime;
    TextView txtPeriod;
    TextView hometxt;
    TextView awaytxt;

    private int homeshot,awayshot = 0;
    private int playernum=0;
    int matchTime = hockey.icescore.OldClasses.Game.periodLength*60;
    int period = 1;
    int time = 0;
    int awayasscount=awayass;
    int homeasscount=homeass;
    int goalPlayerNum=0;
    int gameId = 1;
    int homeGoalieId = 0;
    int awayGoalieId = 0;
    int homeAssistId = 0;
    int homeAssistId2 = 0;
    int awayAssistId = 0;
    int awayAssistId2 = 0;

    private enum Selected  {HOME,AWAY};
    Selected selected = Selected.HOME;


    public void setCurPlayer(String num){
        playernum=Integer.parseInt(num);

        switch(selected){
            case HOME:
                if(playernum == 0) {
                    switch(homeasscount){
                        case(1):
                            homeAssist="No Assist";
                            homeAssist2="";
                            break;
                        case(2):
                            homeAssist2="No Assist";
                            break;
                    }
                    homeasscount=2;
                }



                if(homeasscount<=2){
                    if(homeasscount<2) {
                        PlayerListLeft p1 = new PlayerListLeft();
                        p1.setListener(this);
                        p1.setTeam(hockey.icescore.OldClasses.Game.homeTeam);

                        android.app.FragmentManager manager1 = getFragmentManager();
                        android.app.FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.add(android.R.id.content, p1, "left frag");

                        transaction1.commit();
                        p1.isAssist(true);
                    }
                    if(homeasscount>0){
                        switch(homeasscount){
                            case(1):
                                homeAssist=""+playernum;
                                break;
                            case(2):
                                homeAssist2=""+playernum;
                                break;
                        }

                    } else {
                        goalPlayerNum=playernum;
                    }

                    homeasscount++;
                } if(homeasscount==3){
                Goal goal = new Goal(0, period + "", playernum, -1, -1, false);

                // Creating the GamePersonAction and GamePersonActionGoal model instances
                // to send the data properly to the controller to add the rows into the database
                // Lucas

                /*
                GamePersonAction gpa = new GamePersonAction(
                        hockey.icescore.OldClasses.Game.homeTeam.getPlayerByNumber(playernum).getID(),
                        Constants.ACTION_GOAL_ID, hockey.icescore.OldClasses.Game.homeTeam.getTeamID(),
                        period, hockey.icescore.OldClasses.Game.gameID, txtTime.getText().toString());
                GamePersonActionGoal gpag = new GamePersonActionGoal(awayGoalieId, homeAssistId,
                        homeAssistId2);
                actionController.insertGoal(gpa, gpag, playernum,
                        hockey.icescore.OldClasses.Game.homeTeam.getTeamName(), homeAssist,
                        homeAssist2);
*/
                Toast toast = Toast.makeText(this, goalPlayerNum+", Period: "+goal.period+", assisted by "+homeAssist+", "+homeAssist2, Toast.LENGTH_SHORT);
                toast.show();
                homeasscount=0;
                homeAssists="";
            }
                break;
            case AWAY:
                if(playernum == 0) {
                    switch(awayasscount){
                        case(1):
                            awayAssist="No Assist";
                            awayAssist2="";
                            break;
                        case(2):
                            awayAssist2="No Assist";
                            break;
                    }
                    awayasscount=2;
                }



                if(awayasscount<=2){
                    if(awayasscount<2) {
                        PlayerListRight p1 = new PlayerListRight();
                        p1.setListener(this);
                        p1.setTeam(awayTeam);

                        android.app.FragmentManager manager1 = getFragmentManager();
                        android.app.FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.add(android.R.id.content, p1, "right frag");

                        transaction1.commit();
                        p1.isAssist(true);
                    }
                    if(awayasscount>0){
                        switch(awayasscount){
                            case(1):
                                awayAssist=""+playernum;
                                break;
                            case(2):
                                awayAssist2=""+playernum;
                                break;
                        }

                    } else {
                        goalPlayerNum=playernum;
                    }

                    awayasscount++;
                } if(awayasscount==3){
                Goal goal = new Goal(0, period + "", playernum, -1, -1, false);
                //dataBase.InsertGoal(goal.goalID,goal.playerID,t.time(),goal.assist1Player,goal.assist2Player,goal.penaltyShootout);
                Toast toast = Toast.makeText(this, goalPlayerNum+", Period: "+goal.period+", assisted by "+awayAssist+", "+awayAssist2, Toast.LENGTH_SHORT);
                toast.show();
                awayasscount=0;
                awayAssists="";
            }
                break;

        }



    }

    // Code that is run as soon as the activity starts.
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initializing the controller for the database interaction.
        actionController = new ActionController(gameContext);
        timerController = new TimerController(gameContext);

        Button btnMenuOthers = (Button) findViewById(R.id.btnOthers);
        btnMenuOthers.setOnClickListener(this);

        Button btnGoalA = (Button) findViewById(R.id.btnGoalA);
        btnGoalA.setOnClickListener(this);

        Button btnGoalB = (Button) findViewById(R.id.btnGoalB);
        btnGoalB.setOnClickListener(this);

        Button btnShotA = (Button) findViewById(R.id.btnShotA);
        btnShotA.setOnClickListener(this);

        Button btnShotB = (Button) findViewById(R.id.btnShotB);
        btnShotB.setOnClickListener(this);

        Button btnTimeoutA = (Button) findViewById(R.id.btnTimeoutA);
        btnTimeoutA.setOnClickListener(this);

        Button btnTimeoutB = (Button) findViewById(R.id.btnTimeoutB);
        btnTimeoutB.setOnClickListener(this);

        Button penaltyA = (Button) findViewById(R.id.btnPenaltyA);
        penaltyA.setOnClickListener(this);

        Button penaltyB = (Button) findViewById(R.id.btnPenaltyB);
        penaltyB.setOnClickListener(this);

        awaytxt = (TextView)findViewById(R.id.txtShotB);
        hometxt = (TextView)findViewById(R.id.txtShotA);
        txtPeriod = (TextView)findViewById(R.id.txtPeriod);

        txtTime = (TextView) findViewById(R.id.txtTime);
        int hours = matchTime / 3600, remainder = matchTime % 3600, minutes = remainder / 60, seconds = remainder % 60;
        txt = format(minutes) + ":" + format(seconds);
        txtTime.setText(txt);
        txtTime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            { //Jack

                /*(
                Intent resultScreen = new Intent(Game.this, Result.class);
                startActivity(resultScreen);
                */
                if(txtTime.getText().equals("End Game")){
                    Intent resultScreen = new Intent(Game.this, Result.class);
                    startActivity(resultScreen);
                }
                if(ticking)
                {
                    t.stop();
                    ticking = false;
                    txtTime.setTextColor(Color.parseColor("#FF0000"));
                }
                else
                {
                    t.start();
                    ticking = true;
                    txtTime.setTextColor(Color.parseColor("#00FF00"));
                    setPeriod();
                }


            }
        });

        workAround worker;
        runOnUiThread(worker = new workAround());
        t= new Timer(worker);
        t.setTime(hockey.icescore.OldClasses.Game.gameTimeInt);
    }

    @Override
    public void buttonClicked(String val) {
        setCurPlayer(val);
    }


    private class workAround implements PropertyChangeListener, Runnable { //Jack
        public void propertyChange(PropertyChangeEvent e) {
            int timerTime = matchTime- t.time();
            time=t.time();
            setGameTimeInt(t.time());

            int hours = timerTime / 3600, remainder = timerTime % 3600, minutes = remainder / 60, seconds = remainder % 60;

            if (hours > 0)
                txt = format(hours) + ":" + format(minutes) + ":" + format(seconds);
            else
                txt = format(minutes) + ":" + format(seconds);
            if(timerTime ==0)
            {
                t.stop();
                t.reset();
                period++;
                ticking = false;
                setTextColor();

            }
            if(period==4)
            {
                txt="End Game";
                period--;


            }

            setText();
            gameTime = txt;
        }

        @Override
        public void run() {

        }
    }
    private String format(int tt){
        DecimalFormat df = new DecimalFormat("00");
        return df.format(tt);
    }
    @Override
    public void onClick(View v)
    {
        switch (v.getId()) //Jack
        {

            case R.id.btnPenaltyA: //Josh
                if(ticking)
                {
                    t.stop();
                    ticking = false;
                    txtTime.setTextColor(Color.parseColor("#FF0000"));
                }
                else
                {
                    t.start();
                    ticking = true;
                    txtTime.setTextColor(Color.parseColor("#00FF00"));
                    setPeriod();
                }
                Intent penaltyA = new Intent(Game.this, Penalty.class);
                startActivity(penaltyA);
                break;

            case R.id.btnPenaltyB: //Josh
                if(ticking)
                {
                    t.stop();
                    ticking = false;
                    txtTime.setTextColor(Color.parseColor("#FF0000"));
                }
                else
                {
                    t.start();
                    ticking = true;
                    txtTime.setTextColor(Color.parseColor("#00FF00"));
                    setPeriod();
                }
                Intent penaltyB = new Intent(Game.this, Penalty.class);
                startActivity(penaltyB);
                break;

        // When the button others is clicked, send the user to the others menu activity.
            case R.id.btnOthers:
                if(ticking)
                {
                    t.stop();
                    ticking = false;
                    txtTime.setTextColor(Color.parseColor("#FF0000"));
                }
                else
                {
                    t.start();
                    ticking = true;
                    txtTime.setTextColor(Color.parseColor("#00FF00"));
                    setPeriod();
                }
                Intent menuOthers = new Intent(Game.this, MenuOthers.class);
                startActivity(menuOthers);
                break;


            // When the home team (left side of the screen) makes a shot, run the following:
            case R.id.btnShotA:

                // Increment the shot counter.
                homeshot++;
                homeass++;

                // Insert a save into the database and create a log object for it if a change is
                // ever needed.
                insertShot(awayGoalieId, hockey.icescore.OldClasses.Game.awayTeam.getTeamID(), period,
                        gameId, txtTime.getText().toString(), awayGoalieNumber,
                        awayTeam.getTeamName());

                // Update the text field with the new number.
                hometxt.setText("" + homeshot);
                break;


            // When the away team (right side of the screen) makes a shot, run the following:
            case R.id.btnShotB:

                // Increment the shot counter.
                awayshot++;
                awayass++;

                // Insert a save into the database and create a log object for it if a change is
                // ever needed.
                insertShot(homeGoalieId, hockey.icescore.OldClasses.Game.homeTeam.getTeamID(), period,
                        gameId, txtTime.getText().toString(), homeGoalieNumber,
                        homeTeam.getTeamName());

                // Update the text field with the new number.
                awaytxt.setText("" + awayshot);
                break;


            // When the home team scores a goal, run the following:
            case R.id.btnGoalA:

                PlayerListLeft p = new PlayerListLeft();
                p.setListener(this);
                p.setTeam(hockey.icescore.OldClasses.Game.homeTeam);
                android.app.FragmentManager manager=getFragmentManager();
                android.app.FragmentTransaction transaction=manager.beginTransaction();
                transaction.add(android.R.id.content, p, "left frag");
                transaction.commit();
                selected = Selected.HOME;
                break;


            // When the away team scores a goal, run the following:
            case R.id.btnGoalB:

                PlayerListRight p1 = new PlayerListRight();
                p1.setListener(this);
                p1.setTeam(hockey.icescore.OldClasses.Game.awayTeam);
                android.app.FragmentManager manager1=getFragmentManager();
                android.app.FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.add(android.R.id.content, p1, "right frag");

                transaction1.commit();
                selected = Selected.AWAY;
                break;


            // When the home team requires a timeout, run the following:
            case R.id.btnTimeoutA:

                // If a timeout has already started, restart the usual timer and finish the timeout.
                if (homeTicking & !awayTicking)
                {
                    t.start();
                    txtTime.setTextColor(Color.parseColor("#00FF00"));
                    homeTicking = false;
                }

                // Check if there are no other timeouts running.
                else if (!awayTicking & !homeTicking)
                {

                    // Stop the timer and change the color to red for the user to see it has stopped.
                    t.stop();
                    setTextColor();
                    homeTicking = true;

                    // Insert a timeout into the database.
                    insertTimeout(hockey.icescore.OldClasses.Game.homeTeam.getTeamID(), gameId,
                            txtTime.getText().toString(),
                            homeTeam.getTeamName());
                }

                break;


            // When the home team requires a timeout, run the following:
            case R.id.btnTimeoutB:

                // If a timeout has already started, restart the usual timer and finish the timeout.
                if (awayTicking & !homeTicking)
                {
                    t.start();
                    txtTime.setTextColor(Color.parseColor("#00FF00"));
                    awayTicking = false;
                }

                // Check if there are no other timeouts running.
                else if (!awayTicking & !homeTicking)
                {

                    // Stop the timer and change the color to red for the user to see it has stopped.
                    t.stop();
                    setTextColor();
                    awayTicking = true;

                    // Insert a timeout into the database.
                    insertTimeout(hockey.icescore.OldClasses.Game.awayTeam.getTeamID(), gameId,
                            txtTime.getText().toString(),
                            awayTeam.getTeamName());
                }

                break;

        }
    }

    // Properties for the timer section (periods, text and color).
    protected void setPeriod(){
        updatePeriod.obtainMessage(1987).sendToTarget();
    }
    protected final Handler updatePeriod = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what == 1987){
                txtPeriod.setText("Period "+period);

            }
        }
    };
    protected void setText(){
        updateTextView.obtainMessage(1988).sendToTarget();
    }
    protected final Handler updateTextView = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what == 1988){
                txtTime.setText(txt);

            }
        }
    };
    protected void setTextColor(){
        updateTextViewColor.obtainMessage(1989).sendToTarget();
    }
    protected final Handler updateTextViewColor = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            if(msg.what == 1989){
                txtTime.setTextColor(Color.parseColor("#FF0000"));

            }
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
/*        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    // Method utilized to insert the shots/saves into the database.
    public void insertShot(int goalieId, int defenseTeamId, int periodId, int gameId,
                           String timestamp, String goalieNumber, String shotTeam)
    {
        GamePersonAction gpa = new GamePersonAction(goalieId, Constants.ACTION_SHOTSAVE_ID,
                defenseTeamId, periodId, gameId, timestamp);

        actionController.insertShotSave(gpa, goalieNumber, shotTeam);
    }

    // Method utilized to insert timeouts into the database.
    public void insertTimeout(int teamId, int gameId, String timestamp, String teamName)
    {
        Timeout t = new Timeout(teamId, gameId, timestamp);

        timerController.timeout(t, teamName);
    }
}
