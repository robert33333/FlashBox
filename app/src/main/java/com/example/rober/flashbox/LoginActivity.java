package com.example.rober.flashbox;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivity.context = this;

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //verficare baza date
                //gasire userID daca exista
                SharedPreferences sharedPref = LoginActivity.context.getSharedPreferences("myPrefs",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("userID", "1");
                editor.commit();
                Data.userID = "1";
                LoginActivity.super.onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog
        //super.onBackPressed();  // optional depending on your needs
    }
}
