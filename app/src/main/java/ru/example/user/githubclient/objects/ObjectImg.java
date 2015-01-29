package ru.example.user.githubclient.objects;

import android.content.Context;
import android.graphics.Bitmap;

import ru.example.user.githubclient.abstracts.ObjectData;
import ru.example.user.githubclient.methods.Cropping;
import ru.example.user.githubclient.methods.RequestData;

/**
 * Created by user on 29.01.15.
 */
public class ObjectImg extends ObjectData
{
    public static Bitmap result;

    public Object getData()
    {
        return result;
    }

    public String getInfo()
    {
        return null;
    }

    public boolean loadData(Context paramContext, String url)
    {
        new RequestData();
        result = RequestData.requestDataImage(url);
        if (result != null)
            new Cropping();
        for (result = Cropping.crop(result); ; result = null)
            return false;
    }
}