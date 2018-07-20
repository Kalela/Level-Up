package com.andela.philskiiiwalker.levelup.home.contract;

import android.content.Context;

import com.andela.philskiiiwalker.levelup.home.model.GithubUsers;

import java.util.ArrayList;

public interface MainActivityContract {

    interface MainView {
        void displayGithubUsers(ArrayList<GithubUsers> userList);

        void dismissDialog(String fetchStatus);

        void displaySnackBar(boolean networkStatus);

        Context getViewContext();
    }
    interface MainPresenter {
        void getGithubUsers();

        boolean getNetworkConnectionState();
    }
}
