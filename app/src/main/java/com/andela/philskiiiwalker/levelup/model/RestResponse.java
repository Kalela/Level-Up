package com.andela.philskiiiwalker.levelup.model;


import java.util.List;

public class RestResponse {

    private List<String> imageurls;
    private List<GithubUser> result;

    public List<GithubUser> getResult() {
        return result;
    }

    public List<String> getImageurls() {
        return imageurls;
    }
}