package com.andela.philskiiiwalker.levelup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DisplayDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("dev_name")) {
            String imageUrl = getIntent().getStringExtra("image_url");
            String devName = getIntent().getStringExtra("dev_name");
            setActivityResources(imageUrl, devName);
        }
    }

    private void setActivityResources(String imageUrl, String devName) {
        TextView developerName = findViewById(R.id.developerNameTextView);
        ImageView devImage = findViewById(R.id.developerImageImageView);

        developerName.setText(devName);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(devImage);
    }

}
