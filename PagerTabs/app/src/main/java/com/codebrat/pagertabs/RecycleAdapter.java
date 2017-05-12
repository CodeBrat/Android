package com.codebrat.pagertabs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.codebrat.java.Movie;

import java.util.List;

/**
 * Created by Bharath on 5/10/2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.MainViewHolder> {

    private List<Movie> movieList;

    public RecycleAdapter(List<Movie> movieList){
        this.movieList = movieList;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_layout, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MainViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.listTitle.setText(movie.getTitle());
        holder.listGenre.setText(movie.getGenre());
        holder.listYear.setText(movie.getYear());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        public TextView listTitle, listGenre, listYear;

        public MainViewHolder(View itemView) {
            super(itemView);
            listTitle = (TextView) itemView.findViewById(R.id.recycle_title);
            listGenre = (TextView) itemView.findViewById(R.id.recycle_genre);
            listYear = (TextView) itemView.findViewById(R.id.recycle_year);
        }

    }
}
