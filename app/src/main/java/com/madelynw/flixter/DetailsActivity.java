package com.madelynw.flixter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.madelynw.flixter.R;

public class DetailsActivity extends AppCompatActivity {

    RatingBar rbRating;
    TextView tvTitle;
    TextView tvRelease;
    TextView tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        /**
        String id = getIntent().getStringExtra("ID");
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvTitle = getIntent().getStringExtra("ID");

        etEnterItem = (EditText) findViewById(R.id.etEnterItem);
        etEnterItem.setText(getIntent().getStringExtra("Task"));
        etEnterItem.setSelection(etEnterItem.getText().length());
         */

    }
}
