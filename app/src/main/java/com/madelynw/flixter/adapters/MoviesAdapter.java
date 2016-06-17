package com.madelynw.flixter.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.madelynw.flixter.R;
import com.madelynw.flixter.models.Movie;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation;

/**
 * Created by madelynw on 6/15/16.
 */
public class MoviesAdapter extends ArrayAdapter<Movie>{

    public MoviesAdapter(Context context, ArrayList<Movie> movies) {
        super(context, android.R.layout.simple_list_item_1, movies);
    }

    // View lookup cache
    private static class ViewHolder {
        TextView tvTitle;
        TextView tvOverview;
    }

    //@BindView(R.id.tvTitle) TextView title;
    //@BindView(R.id.tvOverview) TextView overview;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Movie movie = getItem(position);

        // View lookup cache
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
            viewHolder.tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);
            //viewHolder.tvTitle = (TextView) convertView.findViewById(title);
            //viewHolder.tvOverview = (TextView) convertView.findViewById(overview);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Find the image view
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivPoster);

        // Clear out image from convertView
        ivImage.setImageResource(0);

        // Populate the data into the template view using the data object
        viewHolder.tvTitle.setText(movie.getOriginalTitle());
        viewHolder.tvOverview.setText(movie.getOverview());

        // Check if in landscape mode or not
        boolean isLandscape = getContext().getResources().getConfiguration().orientation ==
                Configuration.ORIENTATION_LANDSCAPE;

        // Load images
        if (isLandscape) {
            Picasso.with(getContext()).load(movie.getBackdropPath())
                    .placeholder(R.mipmap.video_camera)
                    .error(R.mipmap.video_camera)
                    .transform(new RoundedCornersTransformation(10, 10))
                    .resize(900, 0)
                    .into(ivImage);
        } else {
            Picasso.with(getContext()).load(movie.getPosterPath())
                    .placeholder(R.mipmap.video_camera)
                    .error(R.mipmap.video_camera)
                    .transform(new RoundedCornersTransformation(10, 10))
                    .into(ivImage);
        }

        // Debugging
        Log.d("MoviesAdapter", "Position: " + position);

        // Return the view
        return convertView;
    }
}
