package com.example.rober.flashbox.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.DataBase;

import static android.support.constraint.Constraints.TAG;

public class FragmentProfile extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "DATA: "+DataBase.utilizatorCurent.getDate());
        DataBase.inMain=false;
        View view = inflater.inflate(R.layout.layout_profile, container, false);
        ImageView img = (ImageView) view.findViewById(R.id.imageView2);
        TextView tv1 = (TextView) view.findViewById(R.id.user_name);
        TextView tv2 = (TextView) view.findViewById(R.id.user_email);
        TextView tv3 = (TextView) view.findViewById(R.id.user_joindate);

        if(DataBase.utilizatorCurent.getPoza()!=null){
            switch (DataBase.utilizatorCurent.getPoza()){
                case "ball":
                    img.setImageResource(R.drawable.ball);
                    break;
                case "guitar":
                    img.setImageResource(R.drawable.guitar);
                    break;
                case "car":
                    img.setImageResource(R.drawable.car);
                    break;
                default:
                    img.setImageResource(R.drawable.profile);
            }
        }
        else{
            img.setImageResource(R.drawable.profile);
        }
        tv1.setText(DataBase.utilizatorCurent.getNume());
        tv2.setText(DataBase.utilizatorCurent.getEmail());
        tv3.setText(DataBase.utilizatorCurent.getDate());




        return view;
    }

}
