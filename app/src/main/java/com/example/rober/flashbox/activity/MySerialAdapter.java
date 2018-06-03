package com.example.rober.flashbox.activity;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rober.flashbox.MainActivity;
import com.example.rober.flashbox.R;
import com.example.rober.flashbox.SerialActivity;
import com.example.rober.flashbox.date.DataBase;
import com.example.rober.flashbox.date.EpisodFavorit;
import com.example.rober.flashbox.date.Serial;

import java.util.ArrayList;

import static android.support.constraint.Constraints.TAG;
import static com.example.rober.flashbox.date.DataBase.serialCurent;

public class MySerialAdapter extends ArrayAdapter<EpisodFavorit>  {

        public MySerialAdapter(Context context, ArrayList<EpisodFavorit> ef) {
            super(context, 0, ef);
        }

        @NonNull
        @Override
        public View getView(int position, View convertView, @NonNull ViewGroup parent) {
            // Get the data item for this position
            final EpisodFavorit s = getItem(position);

            // Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.myserial_row, parent, false);
            }

            // Populate the data into the template view using the data object
            assert s != null;
            ImageView img = (ImageView) convertView.findViewById(R.id.imgMySerialRow);
            TextView tv1 = (TextView) convertView.findViewById(R.id.tvMySerialRow);
            TextView tv2 = (TextView) convertView.findViewById(R.id.tv2MySerialRow);
            Glide.with(MainActivity.context).load(s.getLink()).override(180, 180) .into(img);

            tv1.setText("S"+s.getNrSezon());
            tv2.setText("E"+s.getNrEpisod());

            // Return the completed view to render on screen
            return convertView;
        }
}


