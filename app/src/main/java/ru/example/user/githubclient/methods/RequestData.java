package ru.example.user.githubclient.methods;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.github.kevinsawicki.http.HttpRequest;
import com.loopj.android.http.Base64;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 29.01.15.
 */
public class RequestData
{

    public  static String aut(){

        try {
            String data = "porter-s:depress785612";
            //
            CredentialsProvider credProvider = new BasicCredentialsProvider();
            credProvider.setCredentials(new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                    new UsernamePasswordCredentials("porter-s", "depress-785612"));
            //
            DefaultHttpClient http = new DefaultHttpClient();
            http.setCredentialsProvider(credProvider);
            //
            HttpPut put = new HttpPut("https://api.github.com/");
            try {
                put.setEntity(new StringEntity(data, "UTF8"));
            } catch (UnsupportedEncodingException e) {
                Log.e("111", "UnsupportedEncoding: ", e);
            }
           // put.addHeader("Content-type","SET CONTENT TYPE HERE IF YOU NEED TO");
            HttpResponse response = http.execute(put);


            HttpEntity entity = response.getEntity();
          //  Log.d("111", "This is what we get back:"+response.getStatusLine().toString()+", "+response.getEntity().toString());
            if (entity != null) {
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                instream.close();
                Log.e("INFO", "OTVET = "+result);
                return result;
            }
            return null;

        } catch (ClientProtocolException e) {
            //
            Log.d("111", "Client protocol exception", e);
        } catch (IOException e) {
            //
            Log.d("111", "IOException", e);
        }
        return null;


}

    public  static String aut2(){


        //String response = HttpRequest.get("http://google.com").body();

        String response = HttpRequest.get("https://api.github.com/authorizations").basic("porter-s", "depress785612").body();

        String token = null;
        Log.e("response", "Response was: " + response);

        try {
            JSONArray jsonArray = new JSONArray(response);

            token=jsonArray.getJSONObject(0).getString("token");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Log.e("response", "token was: " + token);
       /*
        HttpClient httpClient = new DefaultHttpClient();

            HttpPost httppost = new HttpPost("https://api.github.com/");
            HttpResponse httpResponse;

            try {
                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
                //nameValuePairs.add(new BasicNameValuePair("json", "{"+'"'+"username"+'"'+":"+'"'+"porter-s"+'"'+"}"));

                //nameValuePairs.add(new BasicNameValuePair("password","depress785612"));

                //httppost.setParams();
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
                httpResponse = httpClient.execute(httppost);
                String s;
                s = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
                Log.e("aut2", s);

            } catch (Exception e) {

            }
        */
            return null;


    }

    public Boolean Post(HttpClient httpClient){

        boolean result;
        HttpPost httppost = new HttpPost("http://438351.shckiev.web.hosting-test.net/users/login/process");
        HttpResponse httpResponse;

        try {
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("username", "porter-s"));
            nameValuePairs.add(new BasicNameValuePair("password","depress785612"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs,"UTF-8"));
            httpResponse = httpClient.execute(httppost);
            String s;
            s = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            Log.e("", s);
            if(s.equals("1")){
                result = true;
            }
            else result = false;
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public static String connect(String url)
    {

        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(url);

        HttpResponse response;
        try {
            response = httpclient.execute(httpget);
            Log.i("RequestData",response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                instream.close();
                return result;
            }
            return null;

        } catch (Exception e) {}
        return null;
    }

    public static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public  static String aut3() {
        //HttpPost httpPost = new HttpPost("https://api.github.com/");
        //httpPost.setEntity(new UrlEncodedFormEntity(params));
      //  httpPost.setHeader("Authorization", "Basic " + Base64String("porter-s", "depress785612"));
        //String paramString = URLEncodedUtils.format(params, "utf-8");

        HttpClient httpclient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet("https://api.github.com/");
        List <NameValuePair> login = new ArrayList <NameValuePair>();
        login.add(new BasicNameValuePair("username", "login"));
        login.add(new BasicNameValuePair("password", "passwd"));


        //httpGet.setHeader("Authorization", "Basic " +Base64String("porter-s", "depress785612"));
        //httpGet.setHeader("-u",  "porter-s:depress785612");

        HttpResponse response;
        try {
            response = httpclient.execute(httpGet);
            Log.i("aut3",response.getStatusLine().toString());
            HttpEntity entity = response.getEntity();

            if (entity != null) {
                InputStream instream = entity.getContent();
                String result= convertStreamToString(instream);
                Log.d("aut3","result="+result);
                instream.close();
                return result;
            }
            return null;

        } catch (Exception e) {}
        return null;

    }


    private static String Base64String(String login, String pas){

        String text = login+":"+ pas;
        byte[] data = null;
        try {
            data = text.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        String base64 = Base64.encodeToString(data, Base64.DEFAULT);
        return base64;

    }


    public static String requestData(String url)
    {
        return connect(url);
    }

    public static Bitmap requestDataImage(String url)
    {
        Bitmap bitmap = null;
        HttpURLConnection conn = null;
        BufferedInputStream buf_stream = null;
        try {
            Log.v("RequestData", "Starting loading image by URL: " + url);
            conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setDoInput(true);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.connect();
            buf_stream = new BufferedInputStream(conn.getInputStream(), 8192);
            bitmap = BitmapFactory.decodeStream(buf_stream);
            buf_stream.close();
            conn.disconnect();
            buf_stream = null;
            conn = null;
        } catch (MalformedURLException ex) {
            Log.e("RequestData", "Url parsing was failed: " + url);
        } catch (IOException ex) {
            Log.d("RequestData", url + " does not exists");
        } catch (OutOfMemoryError e) {
            Log.w("RequestData", "Out of memory!!!");
            return null;
        } finally {
            if ( buf_stream != null )
                try { buf_stream.close(); } catch (IOException ex) {}
            if ( conn != null )
                conn.disconnect();
        }
        return bitmap;
    }

}
