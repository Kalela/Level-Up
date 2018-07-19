package com.andela.philskiiiwalker.levelup.home.contract;

import com.andela.philskiiiwalker.levelup.home.model.GithubUsers;

import java.util.ArrayList;

public interface MainActivityContract {

    interface MainView {
        void displayGithubUsers(ArrayList<GithubUsers> userList);

        void dismissDialog(String fetchStatus);
    }
    interface MainPresenter {
        void getGithubUsers();
    }
}
