package com.andela.philskiiiwalker.levelup.home.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * This class represents the github view interface.
 */
public class GithubUsersResponse {

    @SerializedName("items")
    public ArrayList<GithubUsers> users;

    public ArrayList<GithubUsers> getUsers() {
        return users;
    }
}