package com.codebrat.multiwindow;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Bharath on 5/1/2017.
 */

public class DefaultPages extends AppCompatActivity implements View.OnClickListener {

    private final String[] links = {"https://www.facebook.com/","https://www.instagram.com/?hl=en", "https://twitter.com/?lang=en", "https://www.google.com/"};
    ImageButton face;
    ImageButton insta;
    ImageButton tweet;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_apps);


        face = (ImageButton) findViewById(R.id.facebook);
        face.setOnClickListener(this);

        insta = (ImageButton) findViewById(R.id.insta);
        insta.setOnClickListener(this);

        tweet = (ImageButton) findViewById(R.id.twitter);
        tweet.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Perform action on click

        String website = null;
        switch(v.getId()) {
            case R.id.facebook:
                website = links[0];
                break;
            case R.id.insta:
                website = links[1];
                break;
            case R.id.twitter:
                website = links[2];
                break;
            default:
                website=links[3];
                break;
        }
        Bundle data = new Bundle();
        data.putString("website", website);
        WebAds ads = new WebAds();
        ads.setArguments(data);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.clickAds, ads, "WEBADS").commit();
    }
}
