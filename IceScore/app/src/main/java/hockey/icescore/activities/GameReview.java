package hockey.icescore.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.List;

import hockey.icescore.R;
import hockey.icescore.controllers.ReviewController;
import hockey.icescore.models.Action;

/**
 * Created by Lucas Angelon on 03-Jun-15.
 */
public class GameReview extends ActionBarActivity
{
    ReviewController reviewController;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_review);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        context = this.getApplicationContext();
        reviewController = new ReviewController(context);

        Spinner gameSpinner = (Spinner) findViewById(R.id.spinnerGame);
        populateSpinner(gameSpinner);
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

    private void populateSpinner(Spinner gameSpinner)
    {
        List<String> games = reviewController.getArrayAdapter();

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, games);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gameSpinner.setAdapter(spinnerAdapter);
    }
}
