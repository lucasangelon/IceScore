package hockey.icescore.activities;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import hockey.icescore.OldClasses.*;
import hockey.icescore.OldClasses.Game;
import hockey.icescore.R;
import hockey.icescore.fragments.CreatePlayer;
import hockey.icescore.util.Fragment_Listener;

import static hockey.icescore.OldClasses.Game.awayTeam;
import static hockey.icescore.OldClasses.Game.homeTeam;

/**
 * Created by Lucas Angelon on 21-Mar-15.
 */
public class AddTeam extends ActionBarActivity implements Fragment_Listener, View.OnClickListener, AdapterView.OnItemClickListener {

    ListView current;
    ListView searchview;
    EditText playerSearch ;
    Team team;
    String homexaway;
    int selected;
    int searchSelected;

   public static ArrayList<Player> spares = new ArrayList<Player>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String newString;
        //temp
        spares.add(new Player(55,"James Osborne",30));
        spares.add(new Player(56,"ImmaBmo",32));
        spares.add(new Player(57,"Gus",56));
        spares.add(new Player(58,"Saruchi",18));
        spares.add(new Player(55,"Shaye Trutwin",68));


        searchview =(ListView) findViewById(R.id.searchList);
        searchview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                searchSelected = position;
            }
        });

        ArrayAdapter<Player> arrayAdapter = new ArrayAdapter<Player>(
                this,
                android.R.layout.simple_list_item_1,
                spares);
        searchview.setAdapter(arrayAdapter);

        current =(ListView) findViewById(R.id.currentPlayersList);
        current.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                selected=position;
            }
        });
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                newString= null;
            } else {
                newString= extras.getString("team");
            }
        } else {
            newString= (String) savedInstanceState.getSerializable("team");
        }
        homexaway = newString;
        setCurrent();

        Button delete = (Button) findViewById(R.id.deleteplayerbutton);
        delete.setOnClickListener(this);

        Button add = (Button) findViewById(R.id.addplayerbutton);
        add.setOnClickListener(this);

        Button create = (Button) findViewById(R.id.createPlayerButton);
        create.setOnClickListener(this);



       playerSearch = (EditText) findViewById(R.id.playersearch);
        playerSearch.addTextChangedListener(new TextWatcher() {
            ArrayList<Player> temp;
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
             temp = new ArrayList<Player>();
                int i = 0;
                while (i<spares.size()) {
                    if(spares.get(i).name.trim().contains(playerSearch.getText().toString().trim()))
                        temp.add(spares.get(i));
                    i++;
                }
                refreshSearch(temp);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_general, menu);
        return true;
    }
    public void refreshSearch(ArrayList<Player> temp)
    {
                ArrayAdapter<Player> arrayAdapter3 = new ArrayAdapter<Player>(
                        this,
                        android.R.layout.simple_list_item_1,
                        temp);
                searchview.setAdapter(arrayAdapter3);
    }

    public void setCurrent()
    {
        switch(homexaway){
            case "home":
                ArrayAdapter<Player> arrayAdapter = new ArrayAdapter<Player>(
                        this,
                        android.R.layout.simple_list_item_1,
                        homeTeam.players );
                current.setAdapter(arrayAdapter);
                this.team = homeTeam;
                ArrayAdapter<Player> arrayAdapter3 = new ArrayAdapter<Player>(
                        this,
                        android.R.layout.simple_list_item_1,
                        spares);
                searchview.setAdapter(arrayAdapter3);
                break;
            case "away":
                ArrayAdapter<Player> arrayAdapter1 = new ArrayAdapter<Player>(
                        this,
                        android.R.layout.simple_list_item_1,
                        awayTeam.players );
                current.setAdapter(arrayAdapter1);
                this.team = awayTeam;
                ArrayAdapter<Player> arrayAdapter4 = new ArrayAdapter<Player>(
                        this,
                        android.R.layout.simple_list_item_1,
                        spares);
                searchview.setAdapter(arrayAdapter4);
                break;


        }
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
    public void buttonClicked(String val) {

    }

    public void removePlayer()
    {
         if(team.getTeamID() == homeTeam.getTeamID())
         {
             spares.add(homeTeam.getPlayer(selected));
             homeTeam.players.remove(selected);
         }
         else
         {
             spares.add(homeTeam.getPlayer(selected));
             awayTeam.players.remove(selected);
         }
    }

    public void addPlayer()
    {
        if(team.getTeamID() == homeTeam.getTeamID())
        {
            homeTeam.players.add(spares.get(searchSelected));
            spares.remove(spares.get(searchSelected));
        }
        else
        {
            awayTeam.players.add(spares.get(searchSelected));
            spares.remove(spares.get(searchSelected));
        }
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.deleteplayerbutton:
                removePlayer();
                setCurrent();
                break;

            case R.id.addplayerbutton:
                addPlayer();
                setCurrent();
                break;

            case R.id.createPlayerButton:
                CreatePlayer p1 = new CreatePlayer();
                android.app.FragmentManager manager1=getFragmentManager();
                android.app.FragmentTransaction transaction1=manager1.beginTransaction();
                transaction1.add(android.R.id.content, p1, "Create player");
                transaction1.commit();
                break;


        }

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this,"you selected "+current.getAdapter().getItem(position),Toast.LENGTH_SHORT).show();

    }
}
