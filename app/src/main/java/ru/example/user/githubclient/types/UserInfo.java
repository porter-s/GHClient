package ru.example.user.githubclient.types;

import java.util.Date;

/**
 * Created by user on 29.01.15.
 */
public class UserInfo {

    private static String login;
    private static String password;

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    public static void setLogin(String login) {
        UserInfo.login = login;
    }

    public static void setPassword(String password) {
        UserInfo.password = password;
    }

}
