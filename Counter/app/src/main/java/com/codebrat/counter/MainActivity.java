package com.codebrat.counter;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button tap;
    Button touch;
    Button contacts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tap = (Button) findViewById(R.id.tapCounter);
        tap.setOnClickListener(this);

        touch = (Button) findViewById(R.id.touchCounter);
        touch.setOnClickListener(this);

        contacts = (Button) findViewById(R.id.contacts);
        contacts.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent counter;
        switch (v.getId()){
            case R.id.tapCounter:
                counter = new Intent(MainActivity.this, TapCounter.class);
                startActivityForResult(counter, 101);
                break;

            case R.id.touchCounter:
                counter = new Intent(MainActivity.this, TouchCounter.class);
                startActivity(counter);
                break;

            case R.id.contacts:
                counter = new Intent();
                counter.setAction(android.content.Intent.ACTION_VIEW);
                counter.setData(ContactsContract.Contacts.CONTENT_URI);
                startActivity(counter);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CodeBrat", "onResume called in "+this.getClass().getSimpleName());
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CodeBrat", "onPause called in "+this.getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CodeBrat", "onStop called in "+this.getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CodeBrat", "onDestroy called in "+this.getClass().getSimpleName());
    }
}
