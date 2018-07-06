package com.andela.philskiiiwalker.levelup.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * This class represents the github view interface.
 */
public class GithubUsersResponse {

    @SerializedName("items")
    public List<GithubUsers> users;

    public List<GithubUsers> getUsers() {
        return users;
    }
}