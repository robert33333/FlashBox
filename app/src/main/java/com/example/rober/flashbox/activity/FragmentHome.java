package com.example.rober.flashbox.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rober.flashbox.MainActivity;
import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.Comanda;
import com.example.rober.flashbox.date.DataBase;
import com.example.rober.flashbox.date.EpisodFavorit;

import java.io.IOException;
import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;
import static com.example.rober.flashbox.date.DataBase.episoadeFavorite;


public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        DataBase.inMain = true;

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                if (DataBase.socket == null) {
                    DataBase.initialize();
                }
                DataBase.getEpisoadeFavorite();
            }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start();
        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        View view = inflater.inflate(R.layout.layout_home, container, false);
        ListView listView = view.findViewById(R.id.myserieslist);

        MySerialAdapter mySerialAdapter = new MySerialAdapter(getActivity().getApplicationContext(), DataBase.episoadeFavorite);
        listView.setAdapter(mySerialAdapter);

        return view;
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstance) {

    }

    public void onDestroyView() {
        DataBase.inMain = false;
        super.onDestroyView();
    }

}
