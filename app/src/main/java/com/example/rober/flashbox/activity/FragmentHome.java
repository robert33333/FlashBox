package com.example.rober.flashbox.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.DataBase;

public class FragmentHome extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.layout_home, container, false);

    }
    public void onViewCreated(View view, @Nullable Bundle savedInstance) {
        TextView tv = (TextView) getView().findViewById(R.id.home_username);
        tv.setText(DataBase.utilizatorCurent.getNume());
    }
}
