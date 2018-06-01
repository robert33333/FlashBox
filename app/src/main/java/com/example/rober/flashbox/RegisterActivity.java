package com.example.rober.flashbox;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rober.flashbox.date.Comanda;
import com.example.rober.flashbox.date.DataBase;
import com.example.rober.flashbox.date.DateUtilizator;

import java.io.IOException;

import static com.example.rober.flashbox.date.DataBase.ois;
import static com.example.rober.flashbox.date.DataBase.oos;


public class RegisterActivity extends AppCompatActivity {

    private EditText userName, userPassword, userEmail;
    private Button regButton;
    private TextView userLogin;
    private static DateUtilizator dateUtilizatorReceived;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName = (EditText) findViewById(R.id.Username);
        userPassword = (EditText) findViewById(R.id.Password);
        userEmail = (EditText) findViewById(R.id.Email);
        regButton = (Button) findViewById(R.id.Confirm);


        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick (View view) {
                if (validate()) {
                    Runnable myRunnable = new Runnable() {
                        @Override
                        public void run() {
                            EditText editTextUsername = findViewById(R.id.editTextUsername);
                            EditText editTextPassword = findViewById(R.id.editTextPassword);
                            try {
                                if (DataBase.socket == null) {
                                    DataBase.initialize();
                                }
                                //   oos.writeObject(new Comanda("login",new DateUtilizator(editTextUsername.getText().toString(),editTextPassword.getText().toString())));
                                Comanda cmd =
                                        new Comanda("register",
                                                new DateUtilizator(userName.getText().toString(), userPassword.getText().toString(), userEmail.getText().toString()));
                                oos.writeObject(cmd);
                                //oos.writeObject("Salut");
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

                        RegisterActivity.super.onBackPressed();
                    } else {
                        //mesaj ceva e gresit
                    }

                }
            }
        });

    }

    private Boolean validate() {
        Boolean result = false;

        String name = userName.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty())
                 Toast.makeText(this, "Please enter all the details",Toast.LENGTH_SHORT).show();
          else result = true;

          return result;
    }
}
