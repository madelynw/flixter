package com.madelynw.flixter;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.madelynw.flixter.R;
import com.madelynw.flixter.models.Movie;
import com.squareup.picasso.Picasso;

import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Movie movie = (Movie) getIntent().getSerializableExtra("Movie");

        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle.setText(movie.getOriginalTitle());

        TextView tvRelease = (TextView) findViewById(R.id.tvRelease);
        tvRelease.setText("Release Date: " + movie.getReleaseDate());

        TextView tvOverview = (TextView) findViewById(R.id.tvOverview);
        tvOverview.setText(movie.getOverview());
        tvOverview.setMovementMethod(new ScrollingMovementMethod());

        RatingBar rbRating = (RatingBar) findViewById(R.id.rbRating);
        rbRating.setRating(movie.getRating());

        // Find the image view
        ImageView ivImage = (ImageView) findViewById(R.id.ivPoster);

        // Clear out image from convertView
        ivImage.setImageResource(0);

        // Load images
        if (movie.backdropPath() != null) {
            Picasso.with(this).load(movie.getBackdropPath())
                    .placeholder(R.mipmap.video_camera)
                    .error(R.mipmap.video_camera)
                    .transform(new RoundedCornersTransformation(10, 10))
                    .into(ivImage);
        }
        else {
            Picasso.with(this).load(movie.getPosterPath())
                    .placeholder(R.mipmap.video_camera)
                    .error(R.mipmap.video_camera)
                    .transform(new RoundedCornersTransformation(10, 10))
                    .into(ivImage);
        }

    }
}
