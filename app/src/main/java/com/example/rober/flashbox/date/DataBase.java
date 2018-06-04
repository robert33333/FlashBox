package com.example.rober.flashbox.date;

import android.provider.ContactsContract;
import android.util.Log;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;

public class DataBase {
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    public static Socket socket;
    public static DateUtilizator utilizatorCurent;
    public static ArrayList<String> listaSeriale;
    public static Serial serialCurent;
    public static boolean isChecked = false;
    public static ArrayList<EpisodFavorit> episoadeFavorite;
    public static boolean inMain = false;
    public static ArrayList<Prieten> listaPrieteni;
    public static boolean addfriend_succes = false;

    public static void initialize() {
        try {
            socket = new Socket("82.77.168.248", 9090);
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getEpisoadeFavorite() {
                episoadeFavorite = null;
                try {
                    oos.writeObject(new Comanda("get Episoade favorite",utilizatorCurent.getIdUtilizator()));
                    episoadeFavorite = (ArrayList<EpisodFavorit>) ois.readObject();
                } catch (IOException e) {
                            e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
    }

    public static void getPrieteni() {
        listaPrieteni = null;
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    if (DataBase.socket == null) {
                        DataBase.initialize();
                    }
                    oos.writeObject(new Comanda("get prieteni", utilizatorCurent.getIdUtilizator()));
                    DataBase.listaPrieteni = (ArrayList<Prieten>) DataBase.ois.readObject();
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
    }

}
