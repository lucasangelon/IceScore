package hockey.icescore.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.support.v4.app.Fragment;

import hockey.icescore.OldClasses.Game;
import hockey.icescore.activities.GameLog;
import hockey.icescore.helper.LogTabListener;
import hockey.icescore.R;
import static hockey.icescore.activities.GameLog.displayList;
import static hockey.icescore.activities.GameLog.filterLogsByPeriodID;

public class GameLogFragment extends Fragment implements View.OnClickListener {

    //ListView gameLogView;
    public static ListView listView;
    public static int logSelected;
    public static ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState)
    {
        final View rootView = inflater.inflate(R.layout.activity_game_log, container, false);
         listView= (ListView) rootView.findViewById(R.id.logList);


        /** Setting the array adapter to the listview */
        filterLogsByPeriodID(LogTabListener.selectedTab);
        adapter = new ArrayAdapter<String>(getActivity().getBaseContext(),
            android.R.layout.simple_list_item_1, GameLog.displayList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                logSelected=position;
            }
        });

        Button delete = (Button) rootView.findViewById(R.id.deleteLogButton);
        delete.setOnClickListener(this);

        return rootView;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.deleteLogButton:
                removeLog();
                break;



        }

    }

    public void removeLog(){

        //check if the list in the current tab has any elements
        if (displayList.size() > 0)
        {
            // The filter list index is different from original arraylist index
            // get the list index in the currentGameLog for displayList
            // displayList stores the elements filter
            int index = GameLog.displayListElementIndex.get(logSelected);
            Game.logs.remove(index);
            GameLog.displayList.remove(logSelected);
            GameLog.filterLogsByPeriodID(LogTabListener.selectedTab);
            listView.setAdapter(adapter);
        }

    }

}
