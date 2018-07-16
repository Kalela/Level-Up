package com.andela.philskiiiwalker.levelup.github_user_profile.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.andela.philskiiiwalker.levelup.R;
import com.bumptech.glide.Glide;


public class DisplayDetailsActivity extends AppCompatActivity {

    Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_details);
        getIncomingIntent();
    }

    private void getIncomingIntent() {
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("dev_name")) {
            setActivityResources();
        }
    }

    private void setActivityResources() {
        String devName = getIntent().getStringExtra("dev_name");
        String profileUrl = getIntent().getStringExtra("html_url");
        String imageUrl = getIntent().getStringExtra("image_url");

        TextView developerName = findViewById(R.id.developerNameTextView);
        ImageView devImage = findViewById(R.id.developerImageImageView);

        developerName.setText(devName);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(devImage);

        shareUserProfile(profileUrl, devName);
    }


    private Intent profileShareIntent(String profileUrl, String devName) {
        StringBuilder message = new StringBuilder();
        message.append(getString(R.string.share_message))
                                .append(devName).append(" - ").append(profileUrl);

        return ShareCompat.IntentBuilder.from(this)
                .setType("text/plain")
                .setText(message)
                .getIntent();

    }

    private void shareUserProfile(final String profileUrl, final String devName) {
        shareButton = findViewById(R.id.shareButton);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(Intent.createChooser(profileShareIntent(profileUrl, devName), "Share profile"));
            }
        });

    }

}
