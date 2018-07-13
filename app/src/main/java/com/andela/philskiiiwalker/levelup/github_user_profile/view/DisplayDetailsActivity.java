package com.andela.philskiiiwalker.levelup.github_user_profile.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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
            String imageUrl = getIntent().getStringExtra("image_url");
            String devName = getIntent().getStringExtra("dev_name");
            setActivityResources(imageUrl, devName);
        }
    }

    private void setActivityResources(String imageUrl, String devName) {
        TextView developerName = findViewById(R.id.developerNameTextView);
        ImageView devImage = findViewById(R.id.developerImageImageView);
        shareButton = findViewById(R.id.shareButton);

        developerName.setText(devName);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(devImage);

        shareUserProfile(imageUrl, devName);
    }

    private void shareUserProfile(final String imageUrl, final String devName) {

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = devName;
                Uri pictureUri = Uri.parse(imageUrl);
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.putExtra(Intent.EXTRA_TEXT, username);
                shareIntent.putExtra(Intent.EXTRA_STREAM, pictureUri);
                shareIntent.setType("image/*");
                shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                startActivity(Intent.createChooser(shareIntent, "Share profile"));
            }
        });

    }

}
