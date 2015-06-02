package hockey.icescore.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import java.lang.reflect.Method;
import java.util.ArrayList;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import hockey.icescore.R;
import hockey.icescore.fragments.GameLogFragment;
import hockey.icescore.helper.LogTabListener;
import hockey.icescore.models.Log;
import hockey.icescore.OldClasses.Game;



/**
 * Created by Suruchi 22-Apr-15.
 */
public class GameLog extends ActionBarActivity {

    private static final String TAG ="GameLog" ;
    public static ArrayList<Log> currentGameLog = new ArrayList<Log>();
    public static ArrayList<String> displayList = new ArrayList<String>();
    public static ArrayList<Integer> displayListElementIndex = new ArrayList<Integer>();
    public static int selectedTab;



    //Declare Fragments of same type as the view for all the tabs are same
    Fragment overtimeFragmentTab = new GameLogFragment();
    Fragment p1FragmentTab       = new GameLogFragment();
    Fragment p2FragmentTab       = new GameLogFragment();
    Fragment p3FragmentTab       = new GameLogFragment();
    Fragment shootoutFragmentTab = new GameLogFragment();
    Fragment noteFragmentTab     = new GameLogFragment();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gamelog);

        ActionBar actionBar = getSupportActionBar();

        // Declare Tab Variable
        ActionBar.Tab overtimeTab,p1Tab,p2Tab,p3Tab, shootoutTab,noteTab;

        //Show Actionbar Home Button
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Creating ActionBar tabs.
        getSupportActionBar().setNavigationMode(getSupportActionBar().NAVIGATION_MODE_TABS);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM | getSupportActionBar().DISPLAY_SHOW_HOME);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Screen handling show Actionbar title.
        getSupportActionBar().setTitle("Game Log");
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        // Setting custom tab Titles
        overtimeTab = actionBar.newTab().setText("Overtime");
        p1Tab = actionBar.newTab().setText("Period 1");
        p2Tab = actionBar.newTab().setText("Period 2");
        p3Tab = actionBar.newTab().setText("Period 3");
        shootoutTab = actionBar.newTab().setText("Shootout");
        noteTab = actionBar.newTab().setText("Notes");

        // Setting tab listeners.
        overtimeTab.setTabListener(new LogTabListener(overtimeFragmentTab));
        p1Tab.setTabListener(new LogTabListener(p1FragmentTab));
        p2Tab.setTabListener(new LogTabListener(p2FragmentTab));
        p3Tab.setTabListener(new LogTabListener(p3FragmentTab));
        shootoutTab.setTabListener(new LogTabListener(shootoutFragmentTab));
        noteTab.setTabListener(new LogTabListener(noteFragmentTab));

        // Adding tabs to the ActionBar.
        actionBar.addTab(p1Tab);
        actionBar.addTab(p2Tab);
        actionBar.addTab(p3Tab);
        actionBar.addTab(shootoutTab);
        actionBar.addTab(overtimeTab);
        actionBar.addTab(noteTab);

        //Addes dummy log of each type for each period
        if (Log.loadDummyData == true){
            Log.loadDummyData = false;
            addLogs();
        }

        // Handle orientation changes.It shows the tabs in one row irrespective of the
        // orientation. Force tabs when activity starts.
        forceStackedTabs();
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
        //Closes the current Activity on back button on actionBar
        finish();
        return true;
    }
    private void forceStackedTabs()
    {
        ActionBar ab = getSupportActionBar();
        disableEmbeddedTabs( ab );

    }
    private void disableEmbeddedTabs(Object ab)
    {
        try {
            Method setHasEmbeddedTabsMethod = ab.getClass().getDeclaredMethod("setHasEmbeddedTabs", boolean.class);
            setHasEmbeddedTabsMethod.setAccessible(true);
            setHasEmbeddedTabsMethod.invoke(ab, false);
        } catch (Exception e) {
            android.util.Log.e(TAG, "Error disabling actionbar embedded", e);
        }
    }
    @Override
    public void onConfigurationChanged(final Configuration config)
    {
        super.onConfigurationChanged(config);
        // Handle orientation changes and forces the Action bar Tabs as
        forceStackedTabs();
    }

    public static void addLogs(){


        Game.setCurrentPeriod(1);
        long id = 101;
        //Add some logs to this arraylist of all the types
        currentGameLog.add(new Log().new Goal(101, "12","Home", "10:31AM", "30", ""));//Goal
        currentGameLog.add(new Log().new Save(101,"10","Home","10:32 AM"));//SAve
        currentGameLog.add(new Log().new Penalty(101,"10","Home","10:33 AM","Time penalty"));//Added a penalty
        currentGameLog.add(new Log().new Injury(101,"10","Home","10:34 AM","Hit enjury"));//Added a injury
        currentGameLog.add(new Log().new Timeout(101,"Home","10:35 AM"));//Added a timeout
        currentGameLog.add(new Log().new ChangeGoalie(101,"10","Home","10:36 AM"));//Added a Change Goalie
        currentGameLog.add(new Log().new GamePeriod(101));//Added a game period
        Game.setCurrentPeriod(2);
        //Add some logs to this arraylist of all the types
        id = 102;
        currentGameLog.add(new Log().new Goal(id, "12","Home", "10:37AM", "30", ""));//Goal
        currentGameLog.add(new Log().new Save(id,"10","Home","10:38 AM"));//SAve
        currentGameLog.add(new Log().new Penalty(id,"10","Home","10:39 AM","Time penalty"));//Added a penalty
        currentGameLog.add(new Log().new Injury(id,"10","Home","10:40 AM","Bit enjury"));//Added a injury
        currentGameLog.add(new Log().new Timeout(id,"Home","10:42 AM"));//Added a timeout
        currentGameLog.add(new Log().new ChangeGoalie(id,"10","Home","10:43 AM"));//Added a Change Goalie
        currentGameLog.add(new Log().new GamePeriod(id));//Added a game period
        Game.setCurrentPeriod(3);
        id = 103;
        currentGameLog.add(new Log().new Goal(id, "12","Home", "10:44 AM", "30", ""));//Goal
        currentGameLog.add(new Log().new Save(id,"10","Home","10:45 AM"));//SAve
        currentGameLog.add(new Log().new Penalty(id,"10","Home","10:46 AM","Time penalty"));//Added a penalty
        currentGameLog.add(new Log().new Injury(id,"10","Home","10:47 AM","Bit enjury"));//Added a injury
        currentGameLog.add(new Log().new Timeout(id,"Home","10:48 AM"));//Added a timeout
        currentGameLog.add(new Log().new ChangeGoalie(id,"10","Home","10:49 AM"));//Added a Change Goalie
        currentGameLog.add(new Log().new GamePeriod(id));//Added a game period
        Game.setCurrentPeriod(4);
        id = 104;
        currentGameLog.add(new Log().new Goal(id, "12","Home", "10:50 AM", "30", ""));//Goal
        currentGameLog.add(new Log().new Save(id,"10","Home","10:51 AM"));//SAve
        currentGameLog.add(new Log().new Penalty(id,"10","Home","10:52 AM","Time penalty"));//Added a penalty
        currentGameLog.add(new Log().new Injury(id,"10","Home","10:53 AM","Bit enjury"));//Added a injury
        currentGameLog.add(new Log().new Timeout(id,"Home","10:54 AM"));//Added a timeout
        currentGameLog.add(new Log().new ChangeGoalie(id,"10","Home","10:55 AM"));//Added a Change Goalie
        currentGameLog.add(new Log().new GamePeriod(id));//Added a game period
        Game.setCurrentPeriod(5);
        id = 105;
        currentGameLog.add(new Log().new Goal(id, "12","Home", "10:56AM", "30", ""));//Goal
        currentGameLog.add(new Log().new Save(id,"10","Home","10:57 AM"));//SAve
        currentGameLog.add(new Log().new Penalty(id,"10","Home","10:58 AM","Time penalty"));//Added a penalty
        currentGameLog.add(new Log().new Injury(id,"10","Home","10:59 AM","Bit enjury"));//Added a injury
        currentGameLog.add(new Log().new Timeout(id,"Home","11:00 AM"));//Added a timeout
        currentGameLog.add(new Log().new ChangeGoalie(id,"10","Home","11:01 AM"));//Added a Change Goalie
        currentGameLog.add(new Log().new GamePeriod(id));//Added a game period
    }

    public static ArrayList<String> filterLogsByPeriodID(long periodId){
        //ArrayList<String> displayList = new ArrayList<String>();
        displayList.clear();
        displayListElementIndex.clear();
        for(int i = 0; i < currentGameLog.size(); i++){
            Log log =  currentGameLog.get(i);

            if (log.getPeriodId() == periodId){
                displayList.add(log.toString());
                displayListElementIndex.add(i);
            }
        }
        return displayList;

    }



}

