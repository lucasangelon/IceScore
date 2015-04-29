package hockey.icescore.activities;

import hockey.icescore.R;

public class TabListener implements android.support.v7.app.ActionBar.TabListener {

	private android.support.v4.app.Fragment fragment;
	
	// The contructor.
	public TabListener(android.support.v4.app.Fragment fragment) {
		this.fragment = fragment;
	}

	// When a tab is tapped, the FragmentTransaction replaces
	// the content of our main layout with the specified fragment;
	// that's why we declared an id for the main layout.


    @Override
    public void onTabSelected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction ) {
        fragmentTransaction.replace(R.id.activity_gamelog, fragment);
    }

    @Override
    public void onTabUnselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
        fragmentTransaction.remove(fragment);
    }

    @Override
    public void onTabReselected(android.support.v7.app.ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

    }


}
