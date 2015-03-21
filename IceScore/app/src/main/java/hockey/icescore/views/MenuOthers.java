package hockey.icescore.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 18-Mar-15.
 */
public class MenuOthers extends ActionBarActivity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_others);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button btnChangeGoalie =  (Button) findViewById(R.id.changeGoalieBtn);
        btnChangeGoalie.setOnClickListener(this);
        Button btnEditOfficials = (Button) findViewById(R.id.editOfficialsClockBtn);
        btnEditOfficials.setOnClickListener(this);
        Button btnEditTeams = (Button) findViewById(R.id.editTeamBtn);
        btnEditTeams.setOnClickListener(this);
        Button btnEditLog = (Button) findViewById(R.id.editGameLogBtn);
        btnEditLog.setOnClickListener(this);
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
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.changeGoalieBtn:
            {
                startIntent(ChangeGoalie.class);
                break;
            }
            case R.id.editOfficialsClockBtn:
            {
                startIntent(Confirmation.class);
                break;
            }
            case R.id.editTeamBtn:
            {
                startIntent(SetupTeam.class);
                break;
            }
            case R.id.editGameLogBtn:
            {
                startIntent(GameLog.class);
                break;
            }
        }
    }

    private void startIntent(Class intentClass)
    {
        Intent navigation = new Intent(MenuOthers.this, intentClass);
        startActivity(navigation);
    }
}
