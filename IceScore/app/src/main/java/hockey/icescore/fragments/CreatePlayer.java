package hockey.icescore.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import hockey.icescore.OldClasses.Game;
import hockey.icescore.OldClasses.Player;
import hockey.icescore.R;
import hockey.icescore.activities.AddTeam;
import hockey.icescore.util.Fragment_Listener;

/**
 * Created by Lucas Angelon on 21-Mar-15.
 */
public class CreatePlayer extends Fragment implements View.OnClickListener
{

    EditText fName;
    EditText lName;
    EditText role;
    Button confirm;
    Button cancel;


    public CreatePlayer() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_create_player, container, false);
        fName = (EditText) rootView.findViewById(R.id.fName);
        lName = (EditText) rootView.findViewById(R.id.lName);
        role = (EditText) rootView.findViewById(R.id.role);

        confirm = (Button) rootView.findViewById(R.id.conf);
        confirm.setOnClickListener(this);
        cancel = (Button) rootView.findViewById(R.id.cancel);
        cancel.setOnClickListener(this);


        return rootView;
    }


    public void end()
    {
        ((AddTeam)getActivity()).setCurrent();
        getActivity().getFragmentManager().beginTransaction().remove(this).commit();

    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.conf: // ID of -55 means generate new ID when connecting to web service
                Player player = new Player(-55,fName.getText().toString()+" "+lName.getText().toString(),5);
                AddTeam.spares.add(player);
                end();
                break;
            case R.id.cancel:
                end();
            break;

        }

    }
}
