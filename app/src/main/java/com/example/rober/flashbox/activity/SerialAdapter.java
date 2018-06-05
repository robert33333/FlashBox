package com.example.rober.flashbox.activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.rober.flashbox.MainActivity;
import com.example.rober.flashbox.R;
import com.example.rober.flashbox.SerialActivity;
import com.example.rober.flashbox.date.DataBase;
import com.example.rober.flashbox.date.Serial;

import java.util.ArrayList;

public class SerialAdapter extends ArrayAdapter<String> {

    public SerialAdapter(Context context, ArrayList<String> seriale) {
        super(context, 0, seriale);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        final String s = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.serial_row, parent, false);
        }

        final TextView numeserial = convertView.findViewById(R.id.textViewSerialRow);
        convertView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(DataBase.serialCurent == null) {
                    DataBase.serialCurent = new Serial();
                }
                DataBase.serialCurent.setNume(s);
                view.getContext().startActivity(new Intent(MainActivity.context, SerialActivity.class));
                }
        });
        // Populate the data into the template view using the data object
        assert s != null;
        numeserial.setText(s);
        // Return the completed view to render on screen
        return convertView;
    }
}
