package hockey.icescore.activities;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import hockey.icescore.OldClasses.Game;
import hockey.icescore.helper.MyCustomBaseAdapter;
import hockey.icescore.R;
import hockey.icescore.helper.SearchResults;

/**
 * Created by Suruchi 28-Mar-15.
 */
public class GameSelect extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    /** Called when the activity is first created. */
    Spinner spinner1,spinner2,spinner3,spinner4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        Calendar cal = Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        int month=cal.get(Calendar.MONTH);
        int day=cal.get(Calendar.DAY_OF_MONTH);

        ArrayList<String> listy = new ArrayList<String>();
        for(int i=1;i<=31;i++) {
            listy.add(i+"");
        }

        spinner1 = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.arrayTeam,android.R.layout.simple_list_item_1);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        //Date picking spinners
        //Day
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter adapter1 = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listy);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        spinner2.setSelection(getIndex(spinner2, String.valueOf(day)));
        //Month
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this,R.array.DatePickerMonth,android.R.layout.simple_list_item_1);
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(this);
        String str = this.getResources().getStringArray(R.array.DatePickerMonth)[month];
        spinner3.setSelection(getIndex(spinner3, str));
        //Year
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        ArrayAdapter adapter3 = ArrayAdapter.createFromResource(this,R.array.DatePickerYear,android.R.layout.simple_list_item_1);
        spinner4.setAdapter(adapter3);
        spinner4.setOnItemSelectedListener(this);
        spinner4.setSelection(getIndex(spinner4, String.valueOf(year)));

   //jack
        //this is temporary
        Game.setGameID(1);
        Game.setHomeTeam(1,"Hawks",5,"John doe");
        Game.homeTeam.addPlayer(1,"Jack kitchener",69);
        Game.homeTeam.addPlayer(2,"Josh Loyd",13);
        Game.homeTeam.addPlayer(3,"Nickola Kerr",22);
        Game.homeTeam.addPlayer(5,"no one",42);
        Game.homeTeam.addPlayer(0,"No Assist",0);
        Game.setAwayTeam(2,"Sharks",3,"uncle sam");
        Game.awayTeam.addPlayer(1,"lucas",13);
        Game.awayTeam.addPlayer(1,"test data",7);
        Game.awayTeam.addPlayer(0,"No Assist",0);


        //List view adapter form loding the games
        ArrayList<SearchResults> searchResults = GetSearchResults();
        final ListView lv1 = (ListView) findViewById(R.id.ListView01);
        lv1.setAdapter(new MyCustomBaseAdapter(this, searchResults));

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                Object o = lv1.getItemAtPosition(position);
                SearchResults fullObject = (SearchResults)o;
                Toast.makeText(GameSelect.this, "You have chosen: " + " " + fullObject.getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private ArrayList<SearchResults> GetSearchResults(){
        ArrayList<SearchResults> results = new ArrayList<SearchResults>();

        SearchResults sr1 = new SearchResults();
        sr1.setName("HOME");
        sr1.setCityState("AWAY");
        sr1.setPhone("VENUE");
        sr1.setDate("DATE");
        sr1.setTime("TIME");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Jane Doe");
        sr1.setCityState("Atlanta, GA");
        sr1.setPhone("469-555-2587");
        sr1.setDate("4/6/2014");
        sr1.setTime("11:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Steve Young");
        sr1.setCityState("Miami, FL");
        sr1.setPhone("305-555-7895");
        sr1.setDate("26/2/2015");
        sr1.setTime("02:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Fred Jones");
        sr1.setCityState("Las Vegas, NV");
        sr1.setPhone("612-555-1234");
        sr1.setDate("19/3/2015");
        sr1.setTime("01:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Bob Marsh");
        sr1.setCityState("New York, NY");
        sr1.setPhone("612-555-5678");
        sr1.setDate("19/3/2015");
        sr1.setTime("01:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Harold Funk");
        sr1.setCityState("Chicago, IL");
        sr1.setPhone("612-555-8765");
        sr1.setDate("10/4/2015");
        sr1.setTime("10:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Scott Dorf");
        sr1.setCityState("Winslow, AZ");
        sr1.setPhone("612-555-5432");
        sr1.setDate("12/2/2014");
        sr1.setTime("10:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Mike Hail");
        sr1.setCityState("Seattle, WA");
        sr1.setPhone("612-555-0961");
        sr1.setDate("12/2/2014");
        sr1.setTime("10:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Suruchi");
        sr1.setCityState("Seattle, WA");
        sr1.setPhone("612-555-0961");
        sr1.setDate("12/2/2014");
        sr1.setTime("10:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Chinmay");
        sr1.setCityState("Seattle, WA");
        sr1.setPhone("612-555-0961");
        sr1.setDate("12/2/2014");
        sr1.setTime("10:20 AM");
        results.add(sr1);

        sr1 = new SearchResults();
        sr1.setName("Mandar");
        sr1.setCityState("Seattle, WA");
        sr1.setPhone("612-555-0961");
        sr1.setDate("12/2/2014");
        sr1.setTime("10:20 AM");
        results.add(sr1);

        return results;
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
            Intent setupTeamScreen = new Intent(this, SetupTeam.class);
            startActivity(setupTeamScreen);
            //this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView myText = (TextView) view;
        switch (parent.getId()) {
            case R.id.spinner:
                Toast.makeText(this, "You Selected " + myText.getText(), Toast.LENGTH_SHORT).show();
                break;

            case R.id.spinner2:
            case R.id.spinner3:
            case R.id.spinner4:
                String str;
                str = "You Selected " + spinner2.getSelectedItem().toString()+" "
                                      + spinner3.getSelectedItem().toString()+" "
                                      + spinner4.getSelectedItem().toString();//myText.getText();
                Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
                // do stuffs with you spinner 2
                break;
            default:
                break;
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    //private method of your class
    private int getIndex(Spinner spinner, String myString){
        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
                break;
            }
        }
        return index;
    }
}
