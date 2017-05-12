package com.codebrat.counter;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Bharath on 5/4/2017.
 */

public class TouchCounter extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    ImageButton tap;
    TextView currentCount;
    Button reset;
    private boolean autoIncrement;
    private final long REPEAT_DELAY = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.touch_counter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tap = (ImageButton) findViewById(R.id.touchCounter);
        tap.setOnClickListener(this);
        tap.setOnTouchListener(this);

        reset = (Button) findViewById(R.id.resetTouch);
        reset.setOnClickListener(this);

        Handler repeatUpdateHandler = new Handler();

    }

    @Override
    public void onClick(View v) {
        currentCount = (TextView) findViewById(R.id.currentTouch);
        switch (v.getId()){
            case R.id.touchCounter:
                increment();
                break;

            case R.id.resetTouch:
                currentCount.setText(String.valueOf(0));
                break;

        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(this, "Action Down", Toast.LENGTH_SHORT).show();
                autoIncrement = true;
                break;

            case MotionEvent.ACTION_UP:
                Toast.makeText(this, "Action Up", Toast.LENGTH_SHORT).show();
                autoIncrement = false;
                break;

        }
        return false;
    }

    private void increment(){
        currentCount = (TextView) findViewById(R.id.currentTouch);
        int count = Integer.parseInt(currentCount.getText().toString().trim());
        currentCount.setText(String.valueOf(count+1));
    }
}
