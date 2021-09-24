 package com.example.news_app;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.news_app.model.Films;

import java.util.List;

 public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {


    private Context mContext;
    private List<Films> mDate;

     public FilmAdapter(Context mContext, List<Films> mDate) {
         this.mContext = mContext;
         this.mDate = mDate;
     }
     @NonNull
     @Override
     public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         View v;
         LayoutInflater inflater = LayoutInflater.from(mContext);
         v = inflater.inflate(R.layout.films_item, viewGroup,  false);
         return new MyViewHolder(v);
     }

     @Override
     public void onBindViewHolder(@NonNull FilmAdapter.MyViewHolder holder, int position) {

         holder.filmTitle.setText(mDate.get(position).getFilmTitle());
         holder.filmDate.setText(mDate.get(position).getFilmDate());
         holder.filmRate.setText(mDate.get(position).getFilmRating());
//         holder.filmDescription.setText(mDate.get(position).getFilmDesc());
         Glide.with(mContext).load("https://image.tmdb.org/t/p/w500"+mDate.get(position).getFilmImage()).into(holder.filmImage);

         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(mContext,Films_Activity.class);
//                 intent.putExtra("filmImage", (Parcelable) Glide.with(mContext).load("https://image.tmdb.org/t/p/w500"+mDate.get(position).getFilmImage()));
                intent.putExtra("filmImage","https://image.tmdb.org/t/p/w500"+mDate.get(position).getFilmImage());
                 intent.putExtra("filmDate",mDate.get(position).getFilmDate());
                 intent.putExtra("filmRate",mDate.get(position).getFilmRating() );
                 intent.putExtra("filmTitle",mDate.get(position).getFilmTitle());
                 intent.putExtra("filmDescription",mDate.get(position).getFilmDesc());
                 mContext.startActivity(intent);
             }
         });

     }

     @Override
     public int getItemCount() {
         return mDate.size();
     }


     public static class MyViewHolder extends RecyclerView.ViewHolder{

         TextView filmTitle;
         TextView filmDate;
         TextView filmRate;
         ImageView filmImage;
//         TextView filmDescription;


         public MyViewHolder(@NonNull View itemView) {
             super(itemView);
             filmDate = itemView.findViewById(R.id.filmDate);
             filmTitle = itemView.findViewById(R.id.filmTitle);
             filmRate = itemView.findViewById(R.id.filmRate);
             filmImage = itemView.findViewById(R.id.filmImage);
//             filmDescription = itemView.findViewById(R.id.filmDescription);

         }
     }

}
