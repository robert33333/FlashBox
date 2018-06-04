package com.example.rober.flashbox.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.DataBase;

public class FragmentSettings extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        DataBase.inMain=false;
        return inflater.inflate(R.layout.layout_settings, container, false);
    }
}
