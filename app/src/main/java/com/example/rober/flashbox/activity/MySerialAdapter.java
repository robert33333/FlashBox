package com.example.rober.flashbox.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rober.flashbox.MainActivity;
import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.EpisodFavorit;

import java.util.ArrayList;

class MySerialAdapter extends ArrayAdapter<EpisodFavorit>  {

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
            ImageView img = convertView.findViewById(R.id.imgMySerialRow);
            TextView tv1 = convertView.findViewById(R.id.tvMySerialRow);
            TextView tv2 = convertView.findViewById(R.id.tv2MySerialRow);
            Glide.with(MainActivity.context).load(s.getLink()).override(180, 180) .into(img);

            tv1.setText("S"+s.getNrSezon());
            tv2.setText("E"+s.getNrEpisod());

            // Return the completed view to render on screen
            return convertView;
        }
}


