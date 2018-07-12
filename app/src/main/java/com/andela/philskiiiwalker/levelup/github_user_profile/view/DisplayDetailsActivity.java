package com.andela.philskiiiwalker.levelup.github_user_profile.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.philskiiiwalker.levelup.R;
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
