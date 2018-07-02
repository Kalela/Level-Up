package com.andela.philskiiiwalker.levelup;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GithubUsersResponse {

    @SerializedName("imageurl")
    private List<String> imageurls;

    @SerializedName("result")
    private List<GithubUser> result;

    public List<GithubUser> getResult() {
        return result;
    }

    public List<String> getImageurls() {
        return imageurls;
    }
}