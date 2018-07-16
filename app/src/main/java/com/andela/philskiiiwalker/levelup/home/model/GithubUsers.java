package com.andela.philskiiiwalker.levelup.home.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class GithubUsers implements Parcelable {
    @SerializedName("login")
    private String username;

    @SerializedName("avatar_url")
    private String profileImage;

    @SerializedName("html_url")
    private String profileUrl;

    protected GithubUsers(Parcel in) {
        username = in.readString();
        profileImage = in.readString();
        profileUrl = in.readString();
    }

    public static final Creator<GithubUsers> CREATOR = new Creator<GithubUsers>() {
        @Override
        public GithubUsers createFromParcel(Parcel in) {
            return new GithubUsers(in);
        }

        @Override
        public GithubUsers[] newArray(int size) {
            return new GithubUsers[size];
        }
    };

    public String getProfileImage() {
        return profileImage;
    }

    public String getUsername() {
        return username;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(username);
        parcel.writeString(profileImage);
        parcel.writeString(profileUrl);
    }
}