package ru.example.user.githubclient.methods;

import android.content.Context;
import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by user on 29.01.15.
 */
public class SaveData {

    public static boolean save(Context context,String fileName, String data){


        try {
            FileOutputStream fos_cach_id = context.openFileOutput(fileName+".dat", Context.MODE_PRIVATE);
            fos_cach_id.write(writeObjectToByteArray(data), 0, writeObjectToByteArray(data).length);
            fos_cach_id.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("SaveData", "Error in writeObjectToByteArray: " + e);
            return false;
        }

        Log.d("SaveData", "Data save "+ fileName);
        return true;
    }

    private static byte[] writeObjectToByteArray(Object object)
    {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        try
        {
            byte [] arrayToReturn;
            oos = new ObjectOutputStream(bos);
            oos.writeObject(object);
            arrayToReturn = bos.toByteArray();
            bos.close();
            oos.close();
            return arrayToReturn;
        } catch (Exception e) {
            Log.e("SaveData", "Error in writeObjectToByteArray: " + e);
        }
        return null;
    }

}
