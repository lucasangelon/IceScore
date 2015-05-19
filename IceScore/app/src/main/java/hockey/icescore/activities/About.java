package hockey.icescore.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import hockey.icescore.R;

/**
 * Created by Josh on 19/05/2015.
 */
public class About extends Activity  {


    private WebView WebView;

    @Override
        protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Get the WebView from the View
        WebView = (WebView) findViewById(R.id.WebViewAbout);

        // Load Html into The WebView
    //    WebView.loadUrl("file:///android_res/layout/activity_about.xml");
    }

}
