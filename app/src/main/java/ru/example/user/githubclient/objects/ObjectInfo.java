package ru.example.user.githubclient.objects;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import ru.example.user.githubclient.abstracts.ObjectData;
import ru.example.user.githubclient.methods.JsonParser;
import ru.example.user.githubclient.methods.RequestData;
import ru.example.user.githubclient.types.InfoHotelType;


/**
 * Created by user on 29.01.15.
 */
public class ObjectInfo extends ObjectData
{
    public static InfoHotelType infoHotel;

    public Object getData()
    {
        return infoHotel;
    }

    public String getInfo()
    {
        return null;
    }

    public boolean loadData(Context paramContext, String url)
    {
        try
        {
            new RequestData();
            String str = RequestData.requestData(url);
            if (str != null)
            {
                JsonParser localJsonParser = new JsonParser();
                JSONObject localJSONObject = new JSONObject(str);
                infoHotel = localJsonParser.jsonParserInfo(paramContext, localJSONObject);
            }
            else
            {
                infoHotel = null;
            }
        }
        catch (JSONException localJSONException)
        {
            localJSONException.printStackTrace();
            Log.e("ObjectInfo", "Error loadData");
            infoHotel = null;
        }
        return false;
    }
}
