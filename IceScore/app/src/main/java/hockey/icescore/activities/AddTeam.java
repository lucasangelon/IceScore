package hockey.icescore.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import hockey.icescore.OldClasses.*;
import hockey.icescore.OldClasses.Game;
import hockey.icescore.R;
import hockey.icescore.util.Fragment_Listener;

/**
 * Created by Lucas Angelon on 21-Mar-15.
 */
public class AddTeam extends ActionBarActivity implements Fragment_Listener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_team);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String newString;
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
        ListView current =(ListView) findViewById(R.id.currentPlayersList);

        switch(newString){
            case "home":
                ArrayAdapter<Player> arrayAdapter = new ArrayAdapter<Player>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Game.homeTeam.players );
                current.setAdapter(arrayAdapter);
            break;
            case "away":
                ArrayAdapter<Player> arrayAdapter1 = new ArrayAdapter<Player>(
                        this,
                        android.R.layout.simple_list_item_1,
                        Game.awayTeam.players );
                current.setAdapter(arrayAdapter1);
                break;

        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_general, menu);
        return true;
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
}
