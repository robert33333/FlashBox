package com.example.rober.flashbox;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class FragmentFriends extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_friends, container, false);

        ListView listView = view.findViewById(R.id.listViewFriends);

        //String [] friends = {"unu","doi","trei"};
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,friends);

        ArrayList<FriendRow> friendRows = new ArrayList<>();
        friendRows.add(new FriendRow("unu"));
        friendRows.add(new FriendRow("doi"));
        friendRows.add(new FriendRow("trei"));

        FriendAdapter friendAdapter = new FriendAdapter(getActivity().getApplicationContext(), friendRows);
        listView.setAdapter(friendAdapter);

        friendAdapter.add(new FriendRow("patru"));
        friendAdapter.add(new FriendRow("cinci"));

        return view;
    }
}
