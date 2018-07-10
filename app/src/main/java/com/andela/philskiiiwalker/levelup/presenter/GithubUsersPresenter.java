package com.andela.philskiiiwalker.levelup.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.andela.philskiiiwalker.levelup.model.GithubUsers;
import com.andela.philskiiiwalker.levelup.model.GithubUsersResponse;
import com.andela.philskiiiwalker.levelup.adapter.GithubUsersAdapter;

import com.andela.philskiiiwalker.levelup.service.GithubService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubUsersPresenter {
    private Context context;

    public GithubUsersPresenter(Context context) {
        this.context = context;
    }

    public void getGithubUsers(final RecyclerView recyclerView) {
        Log.d("presenter","getting users");
        GithubService.getAPI().getResults().enqueue(new Callback<GithubUsersResponse>() {

                    @Override
                    public void onResponse(Call<GithubUsersResponse> call, @NonNull Response<GithubUsersResponse> response) {
                        List<GithubUsers> users = response.body().getUsers();
                        if (users != null) {
                            recyclerView.setAdapter(new GithubUsersAdapter(context, users));
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
