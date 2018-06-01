package com.example.rober.flashbox.activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rober.flashbox.R;

import java.util.ArrayList;

class FriendAdapter extends ArrayAdapter<FriendRow> {
    public FriendAdapter(Context context, ArrayList<FriendRow> users) {
        super(context, 0, users);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        FriendRow friendRow = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.friend_row, parent, false);
        }
        // Lookup view for data population
        ImageView imageView = convertView.findViewById(R.id.imageViewFriendRow);
        imageView.setImageResource(R.drawable.profile);
        TextView username = convertView.findViewById(R.id.textViewFriendRow);
        // Populate the data into the template view using the data object
        assert friendRow != null;
        username.setText(friendRow.username);
        // Return the completed view to render on screen
        return convertView;
    }
}
