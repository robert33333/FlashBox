package com.example.rober.flashbox.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.Comanda;
import com.example.rober.flashbox.date.DataBase;

import java.io.IOException;

import static android.support.constraint.Constraints.TAG;
import static com.example.rober.flashbox.date.DataBase.addfriend_succes;
import static com.example.rober.flashbox.date.DataBase.ois;
import static com.example.rober.flashbox.date.DataBase.oos;
import static com.example.rober.flashbox.date.DataBase.utilizatorCurent;

public class FragmentFriends extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        DataBase.getPrieteni();
        DataBase.inMain=false;
        View view = inflater.inflate(R.layout.layout_friends, container, false);

        ListView listView = view.findViewById(R.id.listViewFriends);

        //String [] friends = {"unu","doi","trei"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,friends);

        FriendAdapter friendAdapter = new FriendAdapter(getActivity().getApplicationContext(), DataBase.listaPrieteni);
        listView.setAdapter(friendAdapter);

        final Button addfriend = view.findViewById(R.id.friends_add_friend_button);
        final EditText et = view.findViewById(R.id.addfriendinput);
        addfriend.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                final String cautat = et.getText().toString();

                Runnable myRunnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (DataBase.socket == null) {
                                DataBase.initialize();
                            }
                            Comanda cmd = new Comanda("add friend", cautat);
                            oos.writeObject(cmd);
                            oos.writeObject((new Comanda("", utilizatorCurent.getIdUtilizator())));
                            addfriend_succes = (boolean) ois.readObject();
                            Log.d(TAG, "testtest: "+addfriend);
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
                    if (addfriend_succes) {
                        Toast.makeText(getContext(),"Adaugarea a avut succes", Toast.LENGTH_LONG).show();
                        View view2 = getActivity().getCurrentFocus();
                        if (view != null) {
                            InputMethodManager imm = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                        }
                        FragmentManager fragmentManager = getFragmentManager();
                        fragmentManager.beginTransaction()
                                .replace(R.id.content_frame,new FragmentFriends())
                                .commit();
                    }
                    else {
                        Toast.makeText(getContext(), "Adaugarea a esuat", Toast.LENGTH_LONG).show();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }


}
