package com.example.news_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class Films_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_films);
        ImageView filmImage1 = findViewById(R.id.filmImage1);
        TextView filmTitle1 = findViewById(R.id.filmTitle1);
        TextView filmDate1 = findViewById(R.id.filmDate1);
        TextView filmDescription = findViewById(R.id.filmDescription);
        TextView filmRate1 = findViewById(R.id.filmRate1);
        TextView filmTitle2 = findViewById(R.id.filmTitle2);

//        filmImage1.setImageResource(getIntent().getIntExtra("filmImage",0));
        String photo = getIntent().getStringExtra("filmImage");
        Glide.with(this).load(photo).into(filmImage1);
        filmTitle1.setText(getIntent().getStringExtra("filmTitle"));
        filmDate1.setText(getIntent().getStringExtra("filmDate"));
        filmDescription.setText(getIntent().getStringExtra("filmDescription"));
        filmRate1.setText(getIntent().getStringExtra("filmRate"));
        filmTitle2.setText(getIntent().getStringExtra("filmTitle"));
    }
}