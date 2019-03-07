package chrikualii.info.catalogmovie.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import chrikualii.info.catalogmovie.Movie;
import chrikualii.info.catalogmovie.R;

/**
 * Created by chirikualii on 20/12/18
 * github.com/chirikualii
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.Holder> {

    ArrayList<Movie> movies = new ArrayList<>();

    public RecyclerViewAdapter(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(R.layout.item_movie,viewGroup,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.bind(movies.get(position));
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    class Holder extends  RecyclerView.ViewHolder{

        ImageView imgPoster;
        TextView txtTitle;
        TextView txtOverview;
        TextView txtReleaseDate;
        Button btnDetail;
        Button btnShare;

        public Holder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.img_poster);
            txtTitle = itemView.findViewById(R.id.txt_title);
            txtOverview = itemView.findViewById(R.id.txt_overview);
            txtReleaseDate = itemView.findViewById(R.id.txt_release_date);
            btnDetail = itemView.findViewById(R.id.btn_detail);
            btnShare = itemView.findViewById(R.id.btn_share);
        }

        public void bind(Movie movie) {


            txtTitle.setText(movie.getTitle());
            txtOverview.setText(movie.getOverview());

        }
    }
}
