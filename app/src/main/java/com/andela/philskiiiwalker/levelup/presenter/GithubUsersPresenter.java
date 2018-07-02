package com.andela.philskiiiwalker.levelup.presenter;

import com.andela.philskiiiwalker.levelup.model.GithubUser;
import com.andela.philskiiiwalker.levelup.view.GithubUsersView;
import com.andela.philskiiiwalker.levelup.service.GithubService;
import com.andela.philskiiiwalker.levelup.model.Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GithubUsersPresenter {
    private GithubUsersView githubUsersView;
    private GithubService githubService;

    public GithubUsersPresenter(GithubUsersView view) {
        this.githubUsersView = view;

        if (this.githubService == null) {
            this.githubService = new GithubService();
        }
    }

    public void getGithubUsers() {
        githubService
                .getAPI()
                .getResults()
                .enqueue(new Callback<Data>() {
                    @Override
                    public void onResponse(Call<Data> call, Response<Data> response) {
                        Data data = response.body();

                        if (data != null && data.getRestResponse() != null) {
                            List<GithubUser> result = data.getRestResponse().getResult();
                            githubUsersView.gitHubUsersReady(result);
                        }
                    }

                    @Override
                    public void onFailure(Call<Data> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
