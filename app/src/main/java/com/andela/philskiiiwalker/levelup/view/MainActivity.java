package com.andela.philskiiiwalker.levelup.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andela.philskiiiwalker.levelup.R;
import com.andela.philskiiiwalker.levelup.presenter.GithubUsersPresenter;


public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        GithubUsersPresenter presenter = new GithubUsersPresenter(this);
        presenter.getGithubUsers(mRecyclerView);

    }

}
