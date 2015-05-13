package hockey.icescore.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;
import android.widget.Toast;

import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 13-Mar-15.
 */
public class Confirmation extends ActionBarActivity implements View.OnClickListener
{

    Spinner periodlen ;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation);
        periodlen= (Spinner)findViewById(R.id.spnPeriodLength);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        findViewById(R.id.btnManagerSignA).setOnClickListener(this);
        findViewById(R.id.btnManagerSignB).setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_confirm)
        {
            hockey.icescore.OldClasses.Game.periodLength=Integer.parseInt(periodlen.getSelectedItem().toString());
            Intent gameScreen = new Intent(this, Game.class);
            startActivity(gameScreen);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // Navigates to capture signature class - Josh
    @Override
    public void onClick(View v) {
        Toast.makeText(this,"Check it",Toast.LENGTH_SHORT);
        Intent intent = new Intent(this, CaptureSignature.class);
        startActivityForResult(intent, 1);
    }
}
