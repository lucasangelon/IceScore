package hockey.icescore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 18-Mar-15.
 */
public class SetupTeam extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_team);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        switch (id)
        {
            case R.id.home:
                this.finish();
                return true;

            case R.id.action_next:
                Intent confirmationScreen = new Intent(this, Confirmation.class);
                startActivity(confirmationScreen);
                return true;

        }

        return super.onOptionsItemSelected(item);
    }
   @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
