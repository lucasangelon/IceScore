package hockey.icescore.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import hockey.icescore.R;
import hockey.icescore.helper.DatabaseManager;
import hockey.icescore.helper.DatabaseSeeder;
import hockey.icescore.util.Constants;

import hockey.icescore.R;

/**
 * Created by Lucas Angelon on 28-Apr-15.
 */
public class Splash extends Activity
{
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
	Context co;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        co = getApplicationContext();
        Thread t = new Thread(new UIHack());
        t.start();

        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Splash.this, MenuMain.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }


    private class UIHack implements Runnable{




        @Override
        public void run() {
            DatabaseManager db = new DatabaseManager(co);
            DatabaseSeeder seedy = new DatabaseSeeder(co);
            seedy.seedAll();
            Log.d("db","seeded");
        }
    }
}
