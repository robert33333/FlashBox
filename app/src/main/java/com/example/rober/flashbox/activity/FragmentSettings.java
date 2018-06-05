package com.example.rober.flashbox.activity;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.rober.flashbox.LoginActivity;
import com.example.rober.flashbox.MainActivity;
import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.DataBase;

import static com.example.rober.flashbox.R.color.colorPrimaryDark;

public class FragmentSettings extends Fragment {
    private static String poza = DataBase.utilizatorCurent.getPoza();
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        DataBase.inMain=false;
        View view = inflater.inflate(R.layout.layout_settings, container, false);

        final Button logout = view.findViewById(R.id.logoutbutton);

        logout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPref = getContext().getSharedPreferences("myPrefs",0);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("nume", null);
                editor.apply();
                MainActivity ma = (MainActivity)getActivity();
                ma.back();
            }
        });

        final LinearLayout ll1 = view.findViewById(R.id.layoutpoza1);
        final LinearLayout ll2 = view.findViewById(R.id.layoutpoza2);
        final LinearLayout ll3 = view.findViewById(R.id.layoutpoza3);
        ll1.setBackground(null);
        ll2.setBackground(null);
        ll3.setBackground(null);

        if(DataBase.utilizatorCurent.getPoza()!=null){
            switch(DataBase.utilizatorCurent.getPoza()) {
                case "car":
                    ll1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    break;
                case "guitar":
                    ll2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    break;
                case "ball":
                    ll3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    break;
            }
        }
        ll1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                ll2.setBackground(null);
                ll3.setBackground(null);
                if(ll1.getBackground()!=null) {
                    ll1.setBackground(null);
                }
                else{
                    ll1.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    poza = "car";
                    DataBase.utilizatorCurent.setPoza(poza);
                    DataBase.updatePoza(poza);
                }
            }
        });
        ll2.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                ll1.setBackground(null);
                ll3.setBackground(null);
                if (ll2.getBackground() != null) {
                    ll2.setBackground(null);
                } else {
                    ll2.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    poza = "guitar";
                    DataBase.utilizatorCurent.setPoza(poza);
                    DataBase.updatePoza(poza);
                }
            }
        });
        ll3.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {
                ll1.setBackground(null);
                ll2.setBackground(null);
                if (ll3.getBackground() != null) {
                    ll3.setBackground(null);
                } else {
                    ll3.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
                    poza = "ball";
                    DataBase.utilizatorCurent.setPoza(poza);
                    DataBase.updatePoza(poza);
                }
            }
        });

        return view;
    }

}
