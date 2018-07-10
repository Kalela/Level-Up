package com.andela.philskiiiwalker.levelup.view;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.andela.philskiiiwalker.levelup.R;
import com.andela.philskiiiwalker.levelup.adapter.GithubUsersAdapter;
import com.andela.philskiiiwalker.levelup.model.GithubUsers;
import com.andela.philskiiiwalker.levelup.presenter.GithubUsersPresenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements GithubUsersPresenter.View {
    static final  String ALL_KEYS = "list_state";
    ArrayList<GithubUsers> users;
    private final GithubUsersPresenter presenter = new GithubUsersPresenter(this);
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList(ALL_KEYS);
            displayGithubUsers(users);
        } else {
            presenter.getGithubUsers();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(ALL_KEYS,(ArrayList<? extends Parcelable>) users);
    }

    @Override
    public void displayGithubUsers(ArrayList<GithubUsers> userList) {
        users = userList;
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter adapter = new GithubUsersAdapter(this, users);
        mRecyclerView.setAdapter(adapter);
    }
}
