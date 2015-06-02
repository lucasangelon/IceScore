package hockey.icescore.helper;

import android.app.Activity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.widget.Toast;

import java.util.ArrayList;

import hockey.icescore.OldClasses.Player;
import hockey.icescore.R;
import hockey.icescore.activities.GameLog;
import hockey.icescore.fragments.GameLogFragment;
import hockey.icescore.models.Log.Goal;
import hockey.icescore.models.Log;


import static android.widget.Toast.*;
import static hockey.icescore.activities.GameLog.filterLogsByPeriodID;

public class LogTabListener  implements android.support.v7.app.ActionBar.TabListener{
	private android.support.v4.app.Fragment  fragment;

    public static ArrayList<Goal> goalLog = new ArrayList<Goal>();
    public static ArrayList<String> game = new ArrayList<String>();
    public static ListView listView;
    public static long selectedTab;

	// The contructor.
	public LogTabListener(android.support.v4.app.Fragment fragment)
    {
        this.fragment = fragment;
	}

	// When a tab is tapped, the FragmentTransaction replaces
	// the content of our main layout with the specified fragment;
	// that's why we declared an id for the main layout.
    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction ) {
        fragmentTransaction.replace(R.id.activity_gamelog, fragment);

        selectedTab =(long) tab.getPosition()+1;
        filterLogsByPeriodID(selectedTab);//as the tab index start with 0 and Periods starts with 1
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
        fragmentTransaction.remove(fragment);
    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }

}
