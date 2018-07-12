package com.andela.philskiiiwalker.levelup.contract;

import com.andela.philskiiiwalker.levelup.model.GithubUsers;

import java.util.ArrayList;

public interface MainActivityContract {

    interface MainView {
        void displayGithubUsers(ArrayList<GithubUsers> userList);
    }
    interface MainPresenter {
        void getGithubUsers();
    }
}
