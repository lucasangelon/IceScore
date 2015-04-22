package hockey.icescore.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.app.Fragment;
import android.app.FragmentManager;
import android.widget.Toast;

import hockey.icescore.OldClasses.Team;
import hockey.icescore.R;
import hockey.icescore.util.Fragment_Listener;


public class PlayerListLeft extends Fragment implements View.OnClickListener {
    Fragment_Listener g;
    View v;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;
    private Button b6;
    private Button b7;
    private Button b8;
    private Button b9;
    private Button b10;
    private Button b11;
    private Button b12;
    private Button b13;
    private Button b14;
    private Button b15;
    Team team;

    public void setListener(Fragment_Listener game) {
        g=game;
    }

    public PlayerListLeft() {

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_player_list_left, container, false);
        b1 = (Button) rootView.findViewById(R.id.b1);
        b2 = (Button) rootView.findViewById(R.id.b2);
        b3 = (Button) rootView.findViewById(R.id.b3);
        b4 = (Button) rootView.findViewById(R.id.b4);
        b5 = (Button) rootView.findViewById(R.id.b5);
        b6 = (Button) rootView.findViewById(R.id.b6);
        b7 = (Button) rootView.findViewById(R.id.b7);
        b8 = (Button) rootView.findViewById(R.id.b8);
        b9 = (Button) rootView.findViewById(R.id.b9);
        b10 = (Button) rootView.findViewById(R.id.b10);
        b11 = (Button) rootView.findViewById(R.id.b11);

        b12 = (Button) rootView.findViewById(R.id.b12);
        b13 = (Button) rootView.findViewById(R.id.b13);
        b14 = (Button) rootView.findViewById(R.id.b14);
        b15 = (Button) rootView.findViewById(R.id.b15);


        Button[] buttons = {b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15};

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.findViewById(R.id.b4).setOnClickListener(this);
        rootView.findViewById(R.id.b5).setOnClickListener(this);
        rootView.findViewById(R.id.b6).setOnClickListener(this);
        rootView.findViewById(R.id.b7).setOnClickListener(this);
        rootView.findViewById(R.id.b8).setOnClickListener(this);
        rootView.findViewById(R.id.b9).setOnClickListener(this);
        rootView.findViewById(R.id.b10).setOnClickListener(this);
        rootView.findViewById(R.id.b11).setOnClickListener(this);
        rootView.findViewById(R.id.b12).setOnClickListener(this);
        rootView.findViewById(R.id.b13).setOnClickListener(this);
        rootView.findViewById(R.id.b14).setOnClickListener(this);
        rootView.findViewById(R.id.b15).setOnClickListener(this);
        v = rootView;



        int counter = 0;
        for(Button b:buttons){
            if(!team.hasNextPlayer(counter)){
                break;
            }
            String s = team.getPlayer(counter).getNumber()+"";

            b.setText(s);
            counter++;
        }



        return rootView;

    }

    public void setTeam(Team t){

        team = t;


    }

    private String getNum(int id){
        TextView returnVal = (TextView) v.findViewById(id);
        return returnVal.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.b1:
                g.buttonClicked(getNum(R.id.b1));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b2:
                g.buttonClicked(getNum(R.id.b2));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b3:
                g.buttonClicked(getNum(R.id.b3));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b4:
                g.buttonClicked(getNum(R.id.b4));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b5:
                g.buttonClicked(getNum(R.id.b5));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b6:
                g.buttonClicked(getNum(R.id.b6));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b7:
                g.buttonClicked(getNum(R.id.b7));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b8:
                g.buttonClicked(getNum(R.id.b8));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b9:
                g.buttonClicked(getNum(R.id.b9));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b10:
                g.buttonClicked(getNum(R.id.b10));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b11:
                g.buttonClicked(getNum(R.id.b11));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b12:
                g.buttonClicked(getNum(R.id.b12));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b13:
                g.buttonClicked(getNum(R.id.b13));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b14:
                g.buttonClicked(getNum(R.id.b14));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;
            case R.id.b15:
                g.buttonClicked(getNum(R.id.b15));
                getActivity().getFragmentManager().beginTransaction().remove(this).commit();
                break;

        }
    }
}