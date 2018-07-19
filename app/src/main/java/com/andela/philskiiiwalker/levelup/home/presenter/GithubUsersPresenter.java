package com.andela.philskiiiwalker.levelup.home.presenter;

import android.content.Context;
import android.support.annotation.NonNull;

import com.andela.philskiiiwalker.levelup.home.contract.MainActivityContract;
import com.andela.philskiiiwalker.levelup.home.model.GithubUsers;
import com.andela.philskiiiwalker.levelup.home.model.GithubUsersResponse;
import com.andela.philskiiiwalker.levelup.home.service.GithubService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.NetworkCheck;

public final class GithubUsersPresenter implements MainActivityContract.MainPresenter {
    MainActivityContract.MainView view;

    public GithubUsersPresenter(MainActivityContract.MainView view) {
        this.view = view;
    }

    @Override
    public void getGithubUsers() {
        GithubService.getAPI().getResults().enqueue(new Callback<GithubUsersResponse>() {

            @Override
            public void onResponse(Call<GithubUsersResponse> call, @NonNull Response<GithubUsersResponse> response) {
                ArrayList<GithubUsers> users = response.body().getUsers();
                if (users != null) {
                    view.displayGithubUsers(users);
                } else {
                    view.displaySnackBar(true);
                }

            }

            @Override
            public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                view.displaySnackBar(false);
            }
        });
    }

    @Override
    public boolean getNetworkConnectionState() {
        return NetworkCheck.getConnectionStatus(view.getViewContext());
    }
}
