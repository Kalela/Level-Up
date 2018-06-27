package com.andela.philskiiiwalker.levelup;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DevAdapter extends RecyclerView.Adapter<DevAdapter.ViewHolder> {

    private ArrayList<String> mList;
    private ArrayList<String> mIconList;
    private Bitmap bitmap;


    public DevAdapter(ArrayList<String> list, ArrayList<String> imageList) {
        mList = list;
        mIconList = imageList;

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
        bitmap = getBitmapFromURL(mIconList.get(i)+".png");
        Drawable image = new BitmapDrawable(bitmap);
//        viewHolder.mImageView.setImageDrawable(image);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public Bitmap getBitmapFromURL(String src){
        try{
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
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
