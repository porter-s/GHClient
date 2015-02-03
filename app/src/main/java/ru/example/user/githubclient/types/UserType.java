package ru.example.user.githubclient.types;

import android.graphics.Bitmap;

/**
 * Created by user on 29.01.15.
 */
public class UserType {

    private static String login;
    private static String password;
    private static String id;
    private static String token;
    private static Bitmap avatar;

    public static String getLogin() {
        return login;
    }

    public static String getPassword() {
        return password;
    }

    public static String getId() {
        return id;
    }

    public static String getToken() {
        return token;
    }

    public static Bitmap getAvatar() {
        return avatar;
    }

    public static void setLogin(String login) {
        UserType.login = login;
    }

    public static void setPassword(String password) {
        UserType.password = password;
    }

    public static void setId(String id) {
        UserType.id = id;
    }

    public static void setToken(String token) {
        UserType.token = token;
    }

    public static void setAvatar_url(Bitmap avatar) {
        UserType.avatar = avatar;
    }
}
