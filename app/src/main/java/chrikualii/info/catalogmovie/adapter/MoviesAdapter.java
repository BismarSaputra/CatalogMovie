package chrikualii.info.catalogmovie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import chrikualii.info.catalogmovie.Movie;
import chrikualii.info.catalogmovie.R;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static final String IMAGE_BASE_URL = "http://image.tmdb.org/t/p/original";

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView overview;
        TextView relaseDate;
        ImageView poster;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = (LinearLayout) v.findViewById(R.id.LinearMovies);
            movieTitle = (TextView) v.findViewById(R.id.txt_title);
            overview = (TextView) v.findViewById(R.id.txt_overview);
            relaseDate = (TextView) v.findViewById(R.id.txt_release_date);
            poster = (ImageView) v.findViewById(R.id.img_poster);
        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }


    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.relaseDate.setText(movies.get(position).getReleaseDate());
        holder.overview.setText(movies.get(position).getOverview());
        Glide.with(context).load(IMAGE_BASE_URL + movies.get(position).getPosterPath())
                .into(holder.poster);
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
