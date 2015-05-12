package hockey.icescore.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import hockey.icescore.OldClasses.*;
import hockey.icescore.OldClasses.Game;
import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 18-Mar-15.
 */
public class SetupTeam extends ActionBarActivity implements View.OnClickListener
{
    Button editATeam;
    Button editBTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_team);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editATeam =(Button) findViewById(R.id.editTeamABtn);
        editATeam.setOnClickListener(this);

        editBTeam =(Button) findViewById(R.id.editTeamBBtn);
        editBTeam.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setup_team, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_next)
        {
            Intent confirmationScreen = new Intent(this, Confirmation.class);
            startActivity(confirmationScreen);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.editTeamABtn:
                Intent navigation = new Intent(this, AddTeam.class);
                navigation.putExtra("team", "home");
                startActivity(navigation);
                break;

            case R.id.editTeamBBtn:
                Intent navigation1 = new Intent(this, AddTeam.class);
                navigation1.putExtra("team", "away");
                startActivity(navigation1);
                break;
        }

    }
}
