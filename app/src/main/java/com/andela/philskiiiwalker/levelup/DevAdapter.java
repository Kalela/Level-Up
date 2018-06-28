package com.andela.philskiiiwalker.levelup;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DevAdapter extends RecyclerView.Adapter<DevAdapter.ViewHolder> {

    private ArrayList<String> mList;
    private ArrayList<String> mImageList;
    private Context mcontext;


    public DevAdapter(Context mcontext, ArrayList<String> list, ArrayList<String> imageList) {
        this.mList = list;
        this.mImageList = imageList;
        this.mcontext = mcontext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(
                viewGroup.getContext()).inflate(R.layout.list_text_view, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.devName = mList.get(i);
        viewHolder.mTextView.setText(mList.get(i));
        Glide.with(mcontext)
                .asBitmap()
                .load(mImageList.get(i))
                .into(viewHolder.mImageView);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public String devName;
        public View mView;
        public TextView mTextView;
        public ImageView mImageView;

        public ViewHolder(@NonNull View view) {
            super(view);
            mView = view;
            mTextView = view.findViewById(R.id.devNameTextView);
            mImageView = view.findViewById(R.id.devImageImageView);
        }
    }
}
