package hockey.icescore.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 13-Mar-15.
 */
public class PlayerList extends Fragment
{

    public PlayerList(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_player_list_left, container, false);
        return rootView;
    }
}