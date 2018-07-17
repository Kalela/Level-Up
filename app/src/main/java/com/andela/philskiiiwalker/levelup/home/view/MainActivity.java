package com.andela.philskiiiwalker.levelup.home.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.andela.philskiiiwalker.levelup.R;
import com.andela.philskiiiwalker.levelup.home.adapter.GithubUsersAdapter;
import com.andela.philskiiiwalker.levelup.home.contract.MainActivityContract;
import com.andela.philskiiiwalker.levelup.home.model.GithubUsers;
import com.andela.philskiiiwalker.levelup.home.presenter.GithubUsersPresenter;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements MainActivityContract.MainView {
    static final  String ALL_KEYS = "list_state";
    ArrayList<GithubUsers> users;
    MainActivityContract.MainPresenter presenter = new GithubUsersPresenter(this);
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    SwipeRefreshLayout swipeRefreshLayout;

    ProgressDialog progressDialog;
    Context mcontext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.my_recycler_view);

        swipeRefreshLayout = findViewById(R.id.refresh_layout);

        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList(ALL_KEYS);
            displayGithubUsers(users);
        } else {
            presenter.getGithubUsers();
        }
        setSwipeRefreshListener();

    }

    private void setSwipeRefreshListener() {
        swipeRefreshLayout = findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                queryApi();

            }
        });
    }

    private void queryApi() {
        String title = String.format("Nairobi java developers");
        progressDialog = ProgressDialog.show(this, title,
                "Loading users...", false, false);
        presenter.getGithubUsers();
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putParcelableArrayList(ALL_KEYS, users);
    }

    public void displayGithubUsers(ArrayList<GithubUsers> userList) {
        users = userList;
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        RecyclerView.Adapter adapter = new GithubUsersAdapter(this, users);
        mRecyclerView.setAdapter(adapter);
        dismissDialog("success");
    }

    @Override
    public void dismissDialog(String fetchStatus) {
        if (progressDialog != null && progressDialog.isShowing()) {
                        progressDialog.dismiss();
        }

        if (swipeRefreshLayout.isRefreshing()) {
            if ("success".equalsIgnoreCase(fetchStatus)) {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(this, "list refreshed",
                        Toast.LENGTH_LONG).show();
                } else {
                swipeRefreshLayout.setRefreshing(false);
                }
        }
    }

    private void initCollapsingToolbar() {
        final CollapsingToolbarLayout collapsingToolbar =
                (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbar.setTitle(" ");
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.appbar_layout);
        appBarLayout.setExpanded(true);

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.setTitle(getString(R.string.app_name));
                    isShow = true;
                } else if (isShow) {
                    collapsingToolbar.setTitle(" ");
                    isShow = false;
                }
            }
        });
    }

}
