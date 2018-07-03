package com.andela.philskiiiwalker.levelup.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.andela.philskiiiwalker.levelup.model.Data;

public interface GithubAPI {
    @GET("users")
    Call<Data> getResults();

}
