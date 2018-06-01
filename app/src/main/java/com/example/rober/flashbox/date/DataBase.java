package com.example.rober.flashbox.date;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DataBase {
    public static ObjectOutputStream oos;
    public static ObjectInputStream ois;
    public static Socket socket;
    public static DateUtilizator utilizatorCurent;

    public static void initialize() {
        try {
            socket = new Socket("82.77.168.248", 9090);
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
