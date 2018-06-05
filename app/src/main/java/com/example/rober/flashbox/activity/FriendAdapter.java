package com.example.rober.flashbox.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.rober.flashbox.MainActivity;
import com.example.rober.flashbox.R;
import com.example.rober.flashbox.date.EpisodFavorit;
import com.example.rober.flashbox.date.Prieten;

import java.util.ArrayList;

import static com.example.rober.flashbox.date.DataBase.listaPrieteni;

class FriendAdapter extends ArrayAdapter<Prieten> {
    public FriendAdapter(Context context, ArrayList<Prieten> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final Prieten p = listaPrieteni.get(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.friend_row, parent, false);
        }

        assert p != null;
        ImageView img = convertView.findViewById(R.id.imageViewFriendRow);
        if(p.getPoza() != null)
        {
            switch (p.getPoza()){
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
        else {
            img.setImageResource(R.drawable.profile);
        }
        TextView username = convertView.findViewById(R.id.textViewFriendRow);
        username.setText(p.getUsername());

        LinearLayout ll = convertView.findViewById(R.id.layoutpozefriends);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        lp.setMargins(20, 20, 20, 20);
        if(ll.getChildCount() > 0)
            ll.removeAllViews();
        for(EpisodFavorit ef : p.getEfprieten()) {
            ImageView ivserial = new ImageView(getContext());
            ivserial.setLayoutParams(lp);
            Glide.with(MainActivity.context).load(ef.getLink()).override(300, 300).into(ivserial);
            ll.addView(ivserial);
        }
        return convertView;
    }
}
