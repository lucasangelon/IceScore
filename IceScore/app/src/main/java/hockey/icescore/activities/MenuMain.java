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
public class MenuMain extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);

        // Add the Game Setup button to the system and the listener.
        Button btnGameSetup = (Button) findViewById(R.id.btnGameSetup);
        btnGameSetup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v)
            {
                // Create an intent to send the user to the confirmation view.
                Intent setupTeamScreen = new Intent(MenuMain.this, GameSelect.class);
                startActivity(setupTeamScreen);
            }
        });
    }
}
