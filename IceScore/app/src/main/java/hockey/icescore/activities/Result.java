package hockey.icescore.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 18-Mar-15.
 */
public class Result extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Button getSignature = (Button) findViewById(R.id.refSignButton);
        getSignature.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(Result.this, CaptureSignature.class);
                startActivityForResult(intent, 1);

                findViewById(R.id.btnTeamASign).setOnClickListener(this);
                findViewById(R.id.btnTeamB).setOnClickListener(this);
            }
        });
    }




}
