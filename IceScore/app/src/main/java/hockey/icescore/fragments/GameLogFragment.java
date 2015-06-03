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
import hockey.icescore.controllers.LogController;
import hockey.icescore.helper.LogTabListener;
import hockey.icescore.R;
import hockey.icescore.models.Log;
import hockey.icescore.util.Constants;

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
            LogController actionLog = new LogController(getActivity().getBaseContext());
            int index = GameLog.displayListElementIndex.get(logSelected);
            int actionType=0;
            long id;

            //Get the type of log element
            Log log = Game.logs.get(index);
            if( log.getClass() == Log.Goal.class){
                actionType = Constants.ACTION_GOAL_ID;
            }
            else if( log.getClass() == Log.Penalty.class){
                actionType = Constants.ACTION_PENALTY_ID;
            }
            else if( log.getClass() == Log.Injury.class ){
                actionType = Constants.ACTION_INJURY_ID;
            }
            else if( log.getClass() == Log.Save.class ){
                actionType = Constants.ACTION_SHOTSAVE_ID;
            }

            //get the Id of the element
            id = log.getId();
            actionLog.deleteAction(id,actionType);

            Game.logs.remove(index);
            GameLog.displayList.remove(logSelected);

            GameLog.filterLogsByPeriodID(LogTabListener.selectedTab);
            listView.setAdapter(adapter);
        }

    }

}
