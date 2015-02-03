package ru.example.user.githubclient.methods;

import android.content.Context;
import android.util.Log;

import ru.example.user.githubclient.Constants;
import ru.example.user.githubclient.objects.ObjectUser;

/**
 * Created by user on 03.02.15.
 */
public class VerificationUserData {

    public static boolean availabilityCheckDataUser(Context _context,ObjectUser user){

        if(user.getData(_context)!=null) {
            Log.d(Constants.TAG + " VerificationUserData", "availabilityCheckDataUser = true");
            return true;
        }

        Log.d(Constants.TAG + " VerificationUserData", "availabilityCheckDataUser = false");
        return false;
    }

}
