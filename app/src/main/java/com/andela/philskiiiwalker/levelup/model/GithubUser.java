package com.andela.philskiiiwalker.levelup.model;

import com.google.gson.annotations.SerializedName;

/**
 * This class represents the github view interface.
 */
public class GithubUser {

    @SerializedName("username")
    private String username;

    @SerializedName("imageurl")
    private String imageurl;


    public String getUserame() {
        return username;
    }

    public String getImageurl() {
        return imageurl;
    }

}