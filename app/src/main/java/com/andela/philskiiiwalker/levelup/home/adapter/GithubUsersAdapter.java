package com.andela.philskiiiwalker.levelup.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.andela.philskiiiwalker.levelup.R;
import com.andela.philskiiiwalker.levelup.home.model.GithubUsers;
import com.andela.philskiiiwalker.levelup.github_user_profile.view.DisplayDetailsActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class GithubUsersAdapter extends RecyclerView.Adapter<GithubUsersAdapter.ViewHolder> {

    private Context mcontext;
    private ArrayList<GithubUsers> users;

    public GithubUsersAdapter(Context mcontext, ArrayList<GithubUsers> users) {
        this.mcontext = mcontext;
        this.users = users;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(
                viewGroup.getContext()).inflate(R.layout.list_text_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GithubUsersAdapter.ViewHolder viewHolder, final int i) {
        final GithubUsers githubUser = users.get(i);
        viewHolder.mTextView.setText(githubUser.getUsername());
        Glide.with(mcontext)
                .asBitmap()
                .load(githubUser.getProfileImage())
                .into(viewHolder.mImageView);

        viewHolder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(mcontext, DisplayDetailsActivity.class);
                intent.putExtra("image_url", githubUser.getProfileImage());
                intent.putExtra("dev_name", githubUser.getUsername());
                mcontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public View mView;
        public TextView mTextView;
        public ImageView mImageView;
        public CardView parentLayout;

        public ViewHolder(@NonNull View view) {
            super(view);
            mView = view;
            mTextView = view.findViewById(R.id.devNameTextView);
            mImageView = view.findViewById(R.id.devImageImageView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
