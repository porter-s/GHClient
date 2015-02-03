package ru.example.user.githubclient.objects;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import ru.example.user.githubclient.Constants;
import ru.example.user.githubclient.abstracts.ObjectData;
import ru.example.user.githubclient.abstracts.ObjectUserAbs;
import ru.example.user.githubclient.methods.JsonParser;
import ru.example.user.githubclient.methods.LoadData;
import ru.example.user.githubclient.methods.RequestData;
import ru.example.user.githubclient.methods.SaveData;
import ru.example.user.githubclient.types.InfoHotelType;
import ru.example.user.githubclient.types.UserType;


/**
 * Created by user on 29.01.15.
 */
public class ObjectUser extends ObjectUserAbs
{

    @Override
    public UserType getData(Context _context) {

        //Загружаем сохраненые ранее данные о пользователе
        UserType buf=(UserType) LoadData.load(_context, Constants.DATA_FILE_NAME);

        //проверяем всю информацию пользователя кроме аватара
        if(buf!=null)
            if((buf.getLogin()!=null)&(buf.getPassword()!=null)&(buf.getPassword()!=null)&(buf.getId()!=null)&(buf.getToken()!=null))
                return buf;
        return null;
    }

    @Override
    public boolean setData(Context _context,UserType _data) {

        if(SaveData.save(_context,_data.getLogin(),_data)) return true;

        return false;
    }
}
