package com.andela.philskiiiwalker.levelup.home.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
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
    android.support.v7.widget.Toolbar toolbar;
    Snackbar snackbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Nairobi Java Developers");
        mRecyclerView = findViewById(R.id.my_recycler_view);

        swipeRefreshLayout = findViewById(R.id.refresh_layout);

        if (savedInstanceState != null) {
            users = savedInstanceState.getParcelableArrayList(ALL_KEYS);
            displayGithubUsers(users);
        } else {
            if (presenter.getNetworkConnectionState()) {
                presenter.getGithubUsers();
            } else {
                displaySnackBar(false);
            }
        }

        setSwipeRefreshListener();

    }

    public void onBackPressed() {
        if(progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }

    private void setSwipeRefreshListener() {

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

    @Override
    public void displaySnackBar(boolean networkStatus) {
        int status = R.string.no_connection;

        if (networkStatus) {
            status = R.string.fetch_failed;
        }
        Snackbar snackbar = Snackbar
                .make(swipeRefreshLayout, status, Snackbar.LENGTH_INDEFINITE)
                .setAction("Try Again", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                                        hideSnackBar();
                                        presenter.getGithubUsers();
                                    }
                });

        snackbar.setActionTextColor(Color.CYAN);

        View sbView = snackbar.getView();
        TextView textView = sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);

        snackbar.show();
    }

    private void hideSnackBar() {
        snackbar.dismiss();
    }


    @Override
    public Context getViewContext() {
        return getApplicationContext();
    }


}
