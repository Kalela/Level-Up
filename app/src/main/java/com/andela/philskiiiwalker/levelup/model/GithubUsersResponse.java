package com.andela.philskiiiwalker.levelup.model;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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