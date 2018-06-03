package com.example.rober.flashbox;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rober.flashbox.activity.SerialAdapter;
import com.example.rober.flashbox.date.Comanda;
import com.example.rober.flashbox.date.DataBase;
import com.example.rober.flashbox.date.DateUtilizator;

import java.io.IOException;
import java.util.ArrayList;

import static com.example.rober.flashbox.date.DataBase.ois;
import static com.example.rober.flashbox.date.DataBase.oos;

public class SearchSerialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_serial);

        Button button = (Button)findViewById(R.id.button_cauta);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        EditText editTextCautare = (EditText) findViewById(R.id.editTextCautare);
                        try {
                            if (DataBase.socket == null) {
                                DataBase.initialize();
                            }
                            //   oos.writeObject(new Comanda("login",new DateUtilizator(editTextUsername.getText().toString(),editTextPassword.getText().toString())));
                            Comanda cmd =
                                    new Comanda("cautare",  editTextCautare.getText().toString());
                            oos.writeObject(cmd);

                            DataBase.listaSeriale  = (ArrayList<String>) ois.readObject();
                           // Toast.makeText(SearchSerialActivity.this, ""+DataBase.listaSeriale.size(),Toast.LENGTH_SHORT).show();

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

                    ListView listView = findViewById(R.id.listViewSearchSeriale);

                    SerialAdapter serialAdapter = new SerialAdapter(getApplicationContext(), DataBase.listaSeriale);
                    listView.setAdapter(serialAdapter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
