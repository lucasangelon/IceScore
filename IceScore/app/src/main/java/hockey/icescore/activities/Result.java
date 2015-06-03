package hockey.icescore.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 18-Mar-15.
 */
public class Result extends Activity implements View.OnClickListener
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViewById(R.id.btnTeamASign).setOnClickListener(this);
        findViewById(R.id.btnTeamBSign).setOnClickListener(this);
        Button getSignature = (Button) findViewById(R.id.refSignButton);
        getSignature.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, CaptureSignature.class);
                startActivityForResult(intent, 1);


            }
        });
    }

    // Navigates to capture signature class - Josh
    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Check it", Toast.LENGTH_SHORT);
        Intent intent = new Intent(this, CaptureSignature.class);
        startActivityForResult(intent, 1);

    }




}
