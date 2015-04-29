package hockey.icescore.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import hockey.icescore.R;

public class AllFragmentTab extends android.support.v4.app.Fragment {
    /*
    Gamelog gamelog;

    public void setLog(int view)
    {
     log.setView(view);

    */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_game_log, container, false);
        ListView list = (ListView) rootView.findViewById(R.id.logList);
        // list.setData(gamelog.getAsList());
        return rootView;
            }
 
}
