package com.andela.philskiiiwalker.levelup.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.andela.philskiiiwalker.levelup.model.GithubUsers;
import com.andela.philskiiiwalker.levelup.model.GithubUsersResponse;
import com.andela.philskiiiwalker.levelup.adapter.GithubUsersAdapter;

import com.andela.philskiiiwalker.levelup.service.GithubService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubUsersPresenter {
    View view;
    private Context context;

    public GithubUsersPresenter(View view) {
        this.view = view;
    }

    public interface View {
        void displayGithubUsers(ArrayList<GithubUsers> users);
    }

    public void getGithubUsers() {
        GithubService.getAPI().getResults().enqueue(new Callback<GithubUsersResponse>() {

                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, @NonNull Response<GithubUsersResponse> response) {
                        ArrayList<GithubUsers> users = response.body().getUsers();
                        if (users != null) {
                            view.displayGithubUsers(users);
                        }

                    }

                    @Override
                    public void onFailure(Call<GithubUsersResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }

}
