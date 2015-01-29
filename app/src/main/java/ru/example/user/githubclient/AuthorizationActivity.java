package ru.example.user.githubclient;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

import ru.example.user.githubclient.methods.LoadData;
import ru.example.user.githubclient.methods.SaveData;
import ru.example.user.githubclient.types.UserInfo;


public class AuthorizationActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        Button bEnter = (Button)findViewById(R.id.aa_bEnter);
        final EditText etLogin = (EditText)findViewById(R.id.aa_etLogin);
        final EditText etPass = (EditText)findViewById(R.id.aa_etPass);


        bEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserInfo.setLogin(etLogin.getText().toString());
                UserInfo.setPassword(etPass.getText().toString());

                SaveData.save(getApplicationContext(),getApplicationContext().getResources().getString(R.string.login_file_name),UserInfo.getLogin());
                SaveData.save(getApplicationContext(),getApplicationContext().getResources().getString(R.string.password_file_name),UserInfo.getPassword());

                Toast.makeText(getApplicationContext(),"Load \nlogin= "+LoadData.load(getApplicationContext(),"Login")+"\npass= "+LoadData.load(getApplicationContext(),"Pass"),Toast.LENGTH_SHORT).show();
            }
        });
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
