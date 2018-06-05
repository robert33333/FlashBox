package com.example.rober.flashbox.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.DataBase;


public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        DataBase.inMain=true;
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

}
