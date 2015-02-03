package ru.example.user.githubclient.abstracts;

import android.content.Context;

import ru.example.user.githubclient.types.UserType;

/**
 * Created by user on 29.01.15.
 */

public abstract class ObjectUserAbs
{
    private Object Object;

    public abstract UserType getData(Context _context);

    public abstract boolean setData(Context _context,UserType _data);
}

