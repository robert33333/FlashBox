package com.example.rober.flashbox;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rober.flashbox.date.Comanda;
import com.example.rober.flashbox.date.DataBase;
import com.example.rober.flashbox.date.DateUtilizator;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import static com.example.rober.flashbox.date.DataBase.ois;
import static com.example.rober.flashbox.date.DataBase.oos;
import static com.example.rober.flashbox.date.DataBase.utilizatorCurent;

public class LoginActivity extends AppCompatActivity {
    private static Context context;
    static DateUtilizator dateUtilizatorReceived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LoginActivity.context = this;

        SharedPreferences myPrefs = this.getSharedPreferences("myPrefs", 0);

        if (myPrefs.getString("nume", null)!= null) {
            DataBase.utilizatorCurent = new DateUtilizator(
            myPrefs.getString("nume", null),
            myPrefs.getString("parola", null),
            myPrefs.getString("email", null),
            myPrefs.getString("poza",null));
            DataBase.utilizatorCurent.setIdUtilizator(myPrefs.getInt("idUtilizator",0));
            DataBase.utilizatorCurent.setDate(myPrefs.getString("date", null));

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        Button buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        EditText editTextUsername = findViewById(R.id.editTextUsername);
                        EditText editTextPassword = findViewById(R.id.editTextPassword);
                        try {
                            if (DataBase.socket == null) {
                                DataBase.initialize();
                            }
                            Comanda cmd =
                                    new Comanda("login",
                                            new DateUtilizator(editTextUsername.getText().toString(),
                                                    editTextPassword.getText().toString()));
                            oos.writeObject(cmd);
                            dateUtilizatorReceived = (DateUtilizator) ois.readObject();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }

                    }
                };

                Thread myThread = new Thread(myRunnable);
                myThread.start();
                try {
                    myThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                if (dateUtilizatorReceived != null) {
                    //verificari
                    DataBase.utilizatorCurent = dateUtilizatorReceived;
                    LoginActivity.super.onBackPressed();
                }

                SharedPreferences sharedPref = LoginActivity.context.getSharedPreferences("myPrefs",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("idUtilizator", DataBase.utilizatorCurent.getIdUtilizator());
                editor.putString("nume", DataBase.utilizatorCurent.getNume());
                editor.putString("parola", DataBase.utilizatorCurent.getParola());
                editor.putString("email", DataBase.utilizatorCurent.getEmail());
                editor.putString("date", DataBase.utilizatorCurent.getDate());
                editor.putString("poza",DataBase.utilizatorCurent.getPoza());
                editor.apply();

                startActivity(new Intent(LoginActivity.this, MainActivity.class));

            }
        });
        TextView register;
        register = (TextView) findViewById(R.id.createAccount);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
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
