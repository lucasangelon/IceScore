package hockey.icescore.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DecimalFormat;

import hockey.icescore.OldClasses.Goal;
import hockey.icescore.R;

// everything done by jack

public class Game extends ActionBarActivity implements View.OnClickListener
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
    int matchTime = 10;
    int period = 1;
    private int playernum=0;
    public void setCurPlayer(String num){
        playernum=Integer.parseInt(num);
       Goal goal = new Goal(0, period+"", playernum, -1, -1,false);
        //dataBase.InsertGoal(goal.goalID,goal.playerID,t.time(),goal.assist1Player,goal.assist2Player,goal.penaltyShootout);
        Toast toast = Toast.makeText(this, goal.playerID+", Period: "+goal.period+", no ass", Toast.LENGTH_SHORT);
        toast.show();

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
        private String format(int tt){
            DecimalFormat df = new DecimalFormat("00");
            return df.format(tt);
        }
        @Override
        public void run() {

        }
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
                PlaceholderFragment p = new PlaceholderFragment();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, p )
                        .commit();
                p.setGame(this);

                break;
            case R.id.btnGoalB:
                PlaceholderFragmentRight p1 = new PlaceholderFragmentRight();
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.container, p1 )
                        .commit();
                p1.setGame(this);
                DisplayMetrics displaymetrics = new DisplayMetrics();
                getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
                int width = displaymetrics.widthPixels;

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

    public static class PlaceholderFragment extends Fragment implements View.OnClickListener {
        Game g;
        View v;
        public void setGame(Game game) {
            g=game;
        }

        public PlaceholderFragment() {

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_player_list_left, container, false);
            rootView.findViewById(R.id.b1).setOnClickListener(this);
            rootView.findViewById(R.id.b2).setOnClickListener(this);
            rootView.findViewById(R.id.b3).setOnClickListener(this);
            rootView.findViewById(R.id.b4).setOnClickListener(this);
            rootView.findViewById(R.id.b5).setOnClickListener(this);
            rootView.findViewById(R.id.b6).setOnClickListener(this);
            rootView.findViewById(R.id.b7).setOnClickListener(this);
            rootView.findViewById(R.id.b8).setOnClickListener(this);
            rootView.findViewById(R.id.b9).setOnClickListener(this);
            rootView.findViewById(R.id.b10).setOnClickListener(this);
            rootView.findViewById(R.id.b11).setOnClickListener(this);
            rootView.findViewById(R.id.b12).setOnClickListener(this);
            rootView.findViewById(R.id.b13).setOnClickListener(this);
            rootView.findViewById(R.id.b14).setOnClickListener(this);
            rootView.findViewById(R.id.b15).setOnClickListener(this);
            v = rootView;
            return rootView;

        }

        private String getNum(int id){
          TextView returnVal = (TextView) v.findViewById(id);
            return returnVal.getText().toString();
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.b1:
                    g.setCurPlayer(getNum(R.id.b1));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                break;
                case R.id.b2:
                    g.setCurPlayer(getNum(R.id.b2));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b3:
                    g.setCurPlayer(getNum(R.id.b3));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b4:
                    g.setCurPlayer(getNum(R.id.b4));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b5:
                    g.setCurPlayer(getNum(R.id.b5));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b6:
                    g.setCurPlayer(getNum(R.id.b6));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b7:
                    g.setCurPlayer(getNum(R.id.b7));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b8:
                    g.setCurPlayer(getNum(R.id.b8));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b9:
                    g.setCurPlayer(getNum(R.id.b9));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b10:
                    g.setCurPlayer(getNum(R.id.b10));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b11:
                    g.setCurPlayer(getNum(R.id.b11));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b12:
                    g.setCurPlayer(getNum(R.id.b12));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b13:
                    g.setCurPlayer(getNum(R.id.b13));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b14:
                    g.setCurPlayer(getNum(R.id.b14));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b15:
                    g.setCurPlayer(getNum(R.id.b15));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;

            }
        }
    }

    public static class PlaceholderFragmentRight extends Fragment implements View.OnClickListener {
        Game g;
        View v;
        public void setGame(Game game) {
            g=game;
        }

        public PlaceholderFragmentRight() {

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            View rootView = inflater.inflate(R.layout.fragment_player_list_right, container, false);
            rootView.findViewById(R.id.b1).setOnClickListener(this);
            rootView.findViewById(R.id.b2).setOnClickListener(this);
            rootView.findViewById(R.id.b3).setOnClickListener(this);
            rootView.findViewById(R.id.b4).setOnClickListener(this);
            rootView.findViewById(R.id.b5).setOnClickListener(this);
            rootView.findViewById(R.id.b6).setOnClickListener(this);
            rootView.findViewById(R.id.b7).setOnClickListener(this);
            rootView.findViewById(R.id.b8).setOnClickListener(this);
            rootView.findViewById(R.id.b9).setOnClickListener(this);
            rootView.findViewById(R.id.b10).setOnClickListener(this);
            rootView.findViewById(R.id.b11).setOnClickListener(this);
            rootView.findViewById(R.id.b12).setOnClickListener(this);
            rootView.findViewById(R.id.b13).setOnClickListener(this);
            rootView.findViewById(R.id.b14).setOnClickListener(this);
            rootView.findViewById(R.id.b15).setOnClickListener(this);
            v = rootView;
            return rootView;

        }

        private String getNum(int id){
            TextView returnVal = (TextView) v.findViewById(id);
            return returnVal.getText().toString();
        }

        @Override
        public void onClick(View v) {
            switch(v.getId()){
                case R.id.b1:
                    g.setCurPlayer(getNum(R.id.b1));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b2:
                    g.setCurPlayer(getNum(R.id.b2));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b3:
                    g.setCurPlayer(getNum(R.id.b3));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b4:
                    g.setCurPlayer(getNum(R.id.b4));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b5:
                    g.setCurPlayer(getNum(R.id.b5));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b6:
                    g.setCurPlayer(getNum(R.id.b6));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b7:
                    g.setCurPlayer(getNum(R.id.b7));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b8:
                    g.setCurPlayer(getNum(R.id.b8));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b9:
                    g.setCurPlayer(getNum(R.id.b9));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b10:
                    g.setCurPlayer(getNum(R.id.b10));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b11:
                    g.setCurPlayer(getNum(R.id.b11));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b12:
                    g.setCurPlayer(getNum(R.id.b12));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b13:
                    g.setCurPlayer(getNum(R.id.b13));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b14:
                    g.setCurPlayer(getNum(R.id.b14));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;
                case R.id.b15:
                    g.setCurPlayer(getNum(R.id.b15));
                    getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
                    break;

            }
        }
    }
}
