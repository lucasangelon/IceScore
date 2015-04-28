package hockey.icescore.activities;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import java.lang.reflect.Method;

import hockey.icescore.R;

public class GameLog extends ActionBarActivity implements View.OnClickListener{

    private static final String TAG ="GameLog" ;
    // Declaring our tabs and the corresponding fragments.
    android.support.v7.app.ActionBar.Tab allTab;
    android.support.v7.app.ActionBar.Tab p1Tab;
    android.support.v7.app.ActionBar.Tab p2Tab;
    android.support.v7.app.ActionBar.Tab p3Tab;
    android.support.v7.app.ActionBar.Tab overallTab;


    android.support.v4.app.Fragment allFragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(1);
    android.support.v4.app.Fragment p1FragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(2);
    android.support.v4.app.Fragment p2FragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(3);
    android.support.v4.app.Fragment p3FragmentTab = new AllFragmentTab();
    //allFragmentTab.setLog(4);
    android.support.v4.app.Fragment overallFragmentTab = new AllFragmentTab();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gamelog);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
		
		// Asking for the default ActionBar element that our platform supports.

		 
        // Screen handling while hiding ActionBar icon.
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
 
        // Screen handling while hiding Actionbar title.
        //getSupportActionBar().setDisplayShowTitleEnabled(true);
 
        // Creating ActionBar tabs.
        getSupportActionBar().setNavigationMode(getSupportActionBar().NAVIGATION_MODE_TABS);
        getSupportActionBar().setDisplayOptions(getSupportActionBar().DISPLAY_SHOW_CUSTOM | getSupportActionBar().DISPLAY_SHOW_HOME);

        // Setting custom tab icons.
        allTab = getSupportActionBar().newTab().setText("All");
        p1Tab = getSupportActionBar().newTab().setText("Period 1");
        p2Tab = getSupportActionBar().newTab().setText("Period 2");
        p3Tab = getSupportActionBar().newTab().setText("Period 3");
        overallTab = getSupportActionBar().newTab().setText("Overall");

        

        // Setting tab listeners.
        allTab.setTabListener(new TabListener(allFragmentTab));
        p1Tab.setTabListener(new TabListener(p1FragmentTab));
        p2Tab.setTabListener(new TabListener(p2FragmentTab));
        p3Tab.setTabListener(new TabListener(p3FragmentTab));
        overallTab.setTabListener(new TabListener(overallFragmentTab));

        // Adding tabs to the ActionBar.
        getSupportActionBar().addTab(allTab);
        getSupportActionBar().addTab(p1Tab);
        getSupportActionBar().addTab(p2Tab);
        getSupportActionBar().addTab(p3Tab);
        getSupportActionBar().addTab(overallTab);

        forceStackedTabs(); // Force tabs when activity starts.
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_general, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    private void forceStackedTabs() {
        android.support.v7.app.ActionBar ab = getSupportActionBar();
       // if ( ab instanceof ActionBarImpl ) {
            // Pre-ICS
            disableEmbeddedTabs( ab );
        /*} else if ( ab instanceof ActionBarWrapper ) {
            // ICS
            try {
                Field abField = ab.getClass().getDeclaredField( "mActionBar" );
                abField.setAccessible( true );
                disableEmbeddedTabs( abField.get( ab ) );
            } catch (NoSuchFieldException e) {
                Log.e( TAG, "Error disabling actionbar embedded", e );
            } catch (IllegalArgumentException e) {
                Log.e( TAG, "Error disabling actionbar embedded", e );
            } catch (IllegalAccessException e) {
                Log.e( TAG, "Error disabling actionbar embedded", e );
            }
        }*/
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

    @Override
    public void onClick(View v) {

    }
}

