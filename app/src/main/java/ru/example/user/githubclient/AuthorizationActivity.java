package ru.example.user.githubclient;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import ru.example.user.githubclient.creators.UserCreator;
import ru.example.user.githubclient.methods.RequestData;
import ru.example.user.githubclient.methods.SaveData;
import ru.example.user.githubclient.methods.VerificationUserData;
import ru.example.user.githubclient.objects.ObjectUser;
import ru.example.user.githubclient.service.SFBaseActivity;
import ru.example.user.githubclient.types.UserType;


public class AuthorizationActivity extends SFBaseActivity {

    EditText etPass;
    EditText etLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        Button bEnter = (Button)findViewById(R.id.aa_bEnter);
        etLogin = (EditText)findViewById(R.id.aa_etLogin);
        etPass = (EditText)findViewById(R.id.aa_etPass);

        UserCreator userCreator = new UserCreator();
        ObjectUser user = (ObjectUser) userCreator.create();

        VerificationUserData.availabilityCheckDataUser(getApplicationContext(),user);

      //  AsyncHttpClient client = new AsyncHttpClient();
      //  client.setBasicAuth("porter-s","depress785612");
        logRun();

     //   client.get("https://api.github.com");

        bEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserType.setLogin(etLogin.getText().toString());
                UserType.setPassword(etPass.getText().toString());

                SaveData.save(getApplicationContext(),getApplicationContext().getResources().getString(R.string.login_file_name), UserType.getLogin());
                SaveData.save(getApplicationContext(), getApplicationContext().getResources().getString(R.string.password_file_name), UserType.getPassword());

            }
        });
    }




    protected void logRun(){
        new AsyncTask<Void,Void,Void>(){

            @Override
            protected Void doInBackground(Void... params) {

                RequestData.aut2();

                return null;
            }
        }.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.aa_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
