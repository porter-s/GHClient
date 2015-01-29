package ru.example.user.githubclient.methods;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Created by user on 29.01.15.
 */
public class LoadData {

    public static String load(Context context,String fileName){

        String data;
        try {
            InputStream is = context.openFileInput(fileName+".dat");
            ObjectInputStream oi = new ObjectInputStream(is);
            data = (String) oi.readObject();
            oi.close();
            is.close();
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }
}
