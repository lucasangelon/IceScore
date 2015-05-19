package hockey.icescore.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.lang.reflect.Method;

import hockey.icescore.R;


/**
 * Created by Suruchi 22-Apr-15.
 */
public class GameLog extends ActionBarActivity {

    private static final String TAG ="GameLog" ;
    // Declaring our tabs and the corresponding fragments.
    android.support.v7.app.ActionBar.Tab allTab;
    android.support.v7.app.ActionBar.Tab p1Tab;
    android.support.v7.app.ActionBar.Tab p2Tab;
    android.support.v7.app.ActionBar.Tab p3Tab;
    android.support.v7.app.ActionBar.Tab overallTab;
    android.support.v7.app.ActionBar.Tab noteTab;



    android.support.v4.app.Fragment allFragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(1);
    android.support.v4.app.Fragment p1FragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(2);
    android.support.v4.app.Fragment p2FragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(3);
    android.support.v4.app.Fragment p3FragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(4);
    android.support.v4.app.Fragment overallFragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(5);
    android.support.v4.app.Fragment noteFragmentTab = new AllFragmentTab();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gamelog);

 
        // Creating ActionBar tabs.
        getSupportActionBar().setNavigationMode(getSupportActionBar().NAVIGATION_MODE_TABS);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM | getSupportActionBar().DISPLAY_SHOW_HOME);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Screen handling show Actionbar title.
        getSupportActionBar().setTitle("Game Log");
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        // Setting custom tab icons.
        allTab = getSupportActionBar().newTab().setText("All");
        p1Tab = getSupportActionBar().newTab().setText("Period 1");
        p2Tab = getSupportActionBar().newTab().setText("Period 2");
        p3Tab = getSupportActionBar().newTab().setText("Period 3");
        overallTab = getSupportActionBar().newTab().setText("Overall");
        noteTab = getSupportActionBar().newTab().setText("Notes");

        

        // Setting tab listeners.
        allTab.setTabListener(new TabListener(allFragmentTab));
        p1Tab.setTabListener(new TabListener(p1FragmentTab));
        p2Tab.setTabListener(new TabListener(p2FragmentTab));
        p3Tab.setTabListener(new TabListener(p3FragmentTab));
        overallTab.setTabListener(new TabListener(overallFragmentTab));
        noteTab.setTabListener(new TabListener(noteFragmentTab));

        // Adding tabs to the ActionBar.
        getSupportActionBar().addTab(allTab);
        getSupportActionBar().addTab(p1Tab);
        getSupportActionBar().addTab(p2Tab);
        getSupportActionBar().addTab(p3Tab);
        getSupportActionBar().addTab(overallTab);
        getSupportActionBar().addTab(noteTab);

        forceStackedTabs(); // Force tabs when activity starts.
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
    private void forceStackedTabs() {
        android.support.v7.app.ActionBar ab = getSupportActionBar();
        disableEmbeddedTabs( ab );

    }
    private void disableEmbeddedTabs(Object ab) {
        try {
            Method setHasEmbeddedTabsMethod = ab.getClass().getDeclaredMethod("setHasEmbeddedTabs", boolean.class);
            setHasEmbeddedTabsMethod.setAccessible(true);
            setHasEmbeddedTabsMethod.invoke(ab, false);
        } catch (Exception e) {
            Log.e(TAG, "Error disabling actionbar embedded", e);
        }
    }
    @Override
    public void onConfigurationChanged(final Configuration config) {
        super.onConfigurationChanged(config);
        forceStackedTabs(); // Handle orientation changes.
    }

}

