package com.codebrat.multiwindow;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.util.Log.VERBOSE;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText userInput;
    Button clickChange;
    Button defaults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = (EditText) findViewById(R.id.userInput);
        clickChange = (Button) findViewById(R.id.changeButton);
        defaults = (Button) findViewById(R.id.defaultButton);

        clickChange.setOnClickListener((View.OnClickListener) this);

        defaults.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.changeButton:
                String input = userInput.getText().toString().trim();
                input = input.replaceAll(" ", "+");
                String website = "https://www.google.com/#safe=off&q="+input;
                Bundle data = new Bundle();
                data.putString("website", website);
                WebAds ads = new WebAds();
                ads.setArguments(data);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.searchPage, ads, "WEBADS").commit();
                break;
            case R.id.defaultButton:
                Intent newDefault = new Intent(MainActivity.this, DefaultPages.class);
                startActivity(newDefault);

        }
    }

}
