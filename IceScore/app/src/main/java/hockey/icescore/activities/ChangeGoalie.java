package hockey.icescore.activities;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;

import hockey.icescore.OldClasses.*;
import hockey.icescore.OldClasses.Game;
import hockey.icescore.R;

/**
 * Created by Suruchi 22-Mar-15.
 */
public class ChangeGoalie extends ActionBarActivity
{
    public static ListView listView1,listView2;
    public static ArrayAdapter<String> adapter;
    public static int teamAGoalieSelected=0,teamBGoalieSelected=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_goalie);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // Screen handling show Actionbar title.
        getSupportActionBar().setTitle("Change Goalie");

        listView1= (ListView) findViewById(R.id.listView);
        //listView1.setItemChecked(teamBGoalieSelected).;
        //listView1.setItemChecked(0, true);
        //listView2.setSelection(0);
        //setListViewChecked(true);
        //listView1.setItemChecked(0, true);

        //listView1.setC
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                teamBGoalieSelected=position;
                String[] teamB_array = getResources().getStringArray(R.array.teamB);
                String name = teamB_array[teamBGoalieSelected];
                Game.awayTeam.addGoalie(1, name,10);
                //makeText(rootView.getContext(),"Selected Log" + logSelected+ "ArrayIndex" + GameLog.displayListElementIndex.get(logSelected), Toast.LENGTH_SHORT).show();
            }
        });
        listView2= (ListView) findViewById(R.id.listView2);
        //listView2.setSelection(teamAGoalieSelected);
        listView2.setItemChecked( teamAGoalieSelected, true );
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                teamAGoalieSelected=position;
                String[] teamA_array = getResources().getStringArray(R.array.teamA);
                String name = teamA_array[teamAGoalieSelected];
                Game.homeTeam.addGoalie(1, name,10);
                //makeText(rootView.getContext(),"Selected Log" + logSelected+ "ArrayIndex" + GameLog.displayListElementIndex.get(logSelected), Toast.LENGTH_SHORT).show();
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
    //@Override
//    public void setListViewChecked(boolean checked) {
//        if (checked) {
//            listView1.setBackgroundColor(Color.RED);
//        } else {
//            listView1.setBackgroundColor(Color.BLACK);
//        }
//    }



}
