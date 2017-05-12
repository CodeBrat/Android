package com.codebrat.counter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Bharath on 5/4/2017.
 */

public class TapCounter extends AppCompatActivity implements View.OnClickListener{

    ImageButton tap;
    TextView currentCount;
    Button reset;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tap_counter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tap = (ImageButton) findViewById(R.id.tapCounter);
        tap.setOnClickListener(this);

        reset = (Button) findViewById(R.id.resetTap);
        reset.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        currentCount = (TextView) findViewById(R.id.currentTap);
        switch (v.getId()){
            case R.id.tapCounter:
                int count = Integer.parseInt(currentCount.getText().toString().trim());
                currentCount.setText(String.valueOf(count+1));
                break;

            case R.id.resetTap:
                currentCount.setText(String.valueOf(0));
                break;

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
