package com.andela.philskiiiwalker.levelup.home.presenter;

import com.andela.philskiiiwalker.levelup.home.contract.MainActivityContract;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GithubUsersPresenterTest {


    @Mock
    private MainActivityContract.MainView mView;

    private GithubUsersPresenter mPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mPresenter = new GithubUsersPresenter(mView);
    }

    @Test
    public void getGithubUsers() {
        mPresenter.getGithubUsers();
    }

}