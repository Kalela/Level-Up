package com.andela.philskiiiwalker.levelup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<String> list = new ArrayList<>();
    private ArrayList<String> imageList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDummyData();
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new DevAdapter(list, imageList);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void initDummyData() {
        list.add("Kalela");
        imageList.add("https://avatars2.githubusercontent.com/u/33759757?s=400&u=f632f1d778b2a1bc473683b3be9b42f61a161e94&v=4");

        list.add("meshnesh");
        imageList.add("https://avatars3.githubusercontent.com/u/15923109?s=400&v=4");
    }
}
