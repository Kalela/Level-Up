package com.andela.philskiiiwalker.levelup.home.service;

import com.andela.philskiiiwalker.levelup.home.model.GithubUsersResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GithubAPI {
    @GET("search/users?q=language:java+location:nairobi")
    Call<GithubUsersResponse> getResults();

}
