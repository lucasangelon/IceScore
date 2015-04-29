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
import hockey.icescore.OldClasses.Goal;
import hockey.icescore.R;
import hockey.icescore.fragments.PlayerListLeft;
import hockey.icescore.fragments.PlayerListRight;
import hockey.icescore.util.Fragment_Listener;

// everything done by jack
//dont edit
public class Game extends ActionBarActivity implements View.OnClickListener , Fragment_Listener
{
     Context gameContext = this;
    String txt = "whoop whoop";
    static Timer t;
    boolean ticking = false;
    TextView txtTime;
    TextView txtPeriod;
    private int homeshot,awayshot = 0;
    TextView hometxt;
    TextView awaytxt;
    int matchTime = hockey.icescore.OldClasses.Game.periodLength*60;
    int period = 1;
    private int playernum=0;

    private enum Selected  {HOME,AWAY};
    Selected selected = Selected.HOME;
    int awayasscount=0;
    int homeasscount=0;
    String awayAssists = "";
    String homeAssists = "";
    int goalPlayerNum=0;

    public void setCurPlayer(String num){
        playernum=Integer.parseInt(num);

        switch(selected){
            case HOME:
                if(playernum == -1) {
                    homeasscount=2;
                    homeAssists+="No Assist";
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
                        homeAssists+=""+playernum+", ";

                    } else {
                        goalPlayerNum=playernum;
                    }

                    homeasscount++;
                } if(homeasscount==3){
                Goal goal = new Goal(0, period + "", playernum, -1, -1, false);
                //dataBase.InsertGoal(goal.goalID,goal.playerID,t.time(),goal.assist1Player,goal.assist2Player,goal.penaltyShootout);
                Toast toast = Toast.makeText(this, goalPlayerNum+", Period: "+goal.period+", assisted by "+homeAssists.replaceAll("-1",""), Toast.LENGTH_SHORT);
                toast.show();
                homeasscount=0;
                homeAssists="";
            }
                break;
            case AWAY:
                if(playernum == -1) {
                    awayasscount=2;
                    awayAssists+="No Assist";
                }



                if(awayasscount<=2){
                    if(awayasscount<2) {
                        PlayerListRight p1 = new PlayerListRight();
                        p1.setListener(this);
                        p1.setTeam(hockey.icescore.OldClasses.Game.awayTeam);

                        android.app.FragmentManager manager1 = getFragmentManager();
                        android.app.FragmentTransaction transaction1 = manager1.beginTransaction();
                        transaction1.add(android.R.id.content, p1, "right frag");

                        transaction1.commit();
                        p1.isAssist(true);
                    }
                    if(awayasscount>0){
                        awayAssists+=""+playernum+", ";

                    } else {
                        goalPlayerNum=playernum;
                    }

                    awayasscount++;
                } if(awayasscount==3){
                Goal goal = new Goal(0, period + "", playernum, -1, -1, false);
                //dataBase.InsertGoal(goal.goalID,goal.playerID,t.time(),goal.assist1Player,goal.assist2Player,goal.penaltyShootout);
                Toast toast = Toast.makeText(this, goalPlayerNum+", Period: "+goal.period+", assisted by "+awayAssists.replaceAll("-1",""), Toast.LENGTH_SHORT);
                toast.show();
                awayasscount=0;
                awayAssists="";
            }
                break;

        }



    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {




        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

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

    }

    @Override
    public void buttonClicked(String val) {
        setCurPlayer(val);
    }


    private class workAround implements PropertyChangeListener, Runnable { //Jack
        public void propertyChange(PropertyChangeEvent e) {
            int timerTime = matchTime- t.time();


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
            case R.id.btnOthers:
                Intent menuOthers = new Intent(Game.this, MenuOthers.class);
                startActivity(menuOthers);
                break;
            case R.id.btnShotA:
                homeshot++;

                hometxt.setText(""+homeshot);
                break;
            case R.id.btnShotB:
                awayshot++;
                awaytxt.setText(""+awayshot);
                break;
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
        }
    }

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

}
