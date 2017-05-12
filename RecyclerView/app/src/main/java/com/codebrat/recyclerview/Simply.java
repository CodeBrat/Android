package com.codebrat.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.TextView;

import com.codebrat.java.Movie;

import org.w3c.dom.Text;

/**
 * Created by Bharath on 5/11/2017.
 */

public class Simply extends Activity {

    TextView title;
    TextView genre;
    TextView year;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simply);

        title = (TextView) findViewById(R.id.recycle_title);
        genre = (TextView) findViewById(R.id.recycle_genre);
        year = (TextView) findViewById(R.id.recycle_year);

        Movie movie = getIntent().getParcelableExtra("MovieList");
        Log.d("CodeBrat", movie.getTitle());
        title.setText(movie.getTitle());
        genre.setText(movie.getGenre());
        year.setText(movie.getYear());
    }
}
