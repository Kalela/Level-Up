package com.andela.philskiiiwalker.levelup.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andela.philskiiiwalker.levelup.R;
import com.andela.philskiiiwalker.levelup.adapter.GithubUsersAdapter;
import com.andela.philskiiiwalker.levelup.contract.MainActivityContract;
import com.andela.philskiiiwalker.levelup.model.GithubUsers;
import com.andela.philskiiiwalker.levelup.presenter.GithubUsersPresenter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainActivityContract.MainView {
    static final  String ALL_KEYS = "list_state";
    ArrayList<GithubUsers> users;
    MainActivityContract.MainPresenter presenter = new GithubUsersPresenter(this);

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
        savedInstanceState.putParcelableArrayList(ALL_KEYS, users);
    }

    public void displayGithubUsers(ArrayList<GithubUsers> userList) {
        RecyclerView mRecyclerView;
        RecyclerView.LayoutManager mLayoutManager;

        users = userList;
        mRecyclerView = findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter adapter = new GithubUsersAdapter(this, users);
        mRecyclerView.setAdapter(adapter);
    }

}
