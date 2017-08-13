package com.softuni.utils;

import com.softuni.models.bindingModels.user.LoggedInUser;

/**
 * Created on 1.8.2017 г..
 */
public class Session {
    private static LoggedInUser currentLoggedInUser;

    public static LoggedInUser getLoggedInUser() {
        return currentLoggedInUser;
    }

    public static void setLoggedInUser(LoggedInUser loggedInUser) {
        currentLoggedInUser = loggedInUser;
    }
}
