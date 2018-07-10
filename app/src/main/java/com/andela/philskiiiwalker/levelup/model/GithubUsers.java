package com.andela.philskiiiwalker.levelup.model;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GithubUsers {
    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String profileImage;

    public String getProfileImage() {
        return profileImage;
    }

    public String getUsername() {
        return username;
    }
}