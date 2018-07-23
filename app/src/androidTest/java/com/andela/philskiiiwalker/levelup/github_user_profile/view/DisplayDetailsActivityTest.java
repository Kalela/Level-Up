package com.andela.philskiiiwalker.levelup.github_user_profile.view;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.andela.philskiiiwalker.levelup.R;
import com.andela.philskiiiwalker.levelup.home.model.GithubUsers;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class DisplayDetailsActivityTest {
    private static final GithubUsers MOCKUSER = new GithubUsers("avatar_url", "login", "html_url");

    @Rule
    public IntentsTestRule<DisplayDetailsActivity> detailActivityIntentsTestRule =
            new IntentsTestRule<>(DisplayDetailsActivity.class, true, false);

    /**
     * Setup for the UI test that caters to the User class instance created.
     */
    @Before
    public void intentWithUser() {
        Intent mockIntent = new Intent();
        mockIntent.putExtra("avatar_url", MOCKUSER.getProfileImage());
        mockIntent.putExtra("login", MOCKUSER.getUsername());
        mockIntent.putExtra("html_url", MOCKUSER.getProfileUrl());
        detailActivityIntentsTestRule.launchActivity(mockIntent);
    }

    /**
     * Method to check that the assert created actually contains the created data.
     */
    @Test
    public void userDetailsDisplayed() {
        onView(withId(R.id.developerNameTextView)).check(matches(withText("Username")));
    }
}