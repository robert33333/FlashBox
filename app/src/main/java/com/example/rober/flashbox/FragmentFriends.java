package com.example.rober.flashbox;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class FragmentFriends extends Fragment {

    RecyclerView recyclerView;
    FriendAdapter adapter;

    List<Friend> friendList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_friends, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        friendList = new ArrayList<>();

        recyclerView = view.findViewById(R.id.recyclerview_friend_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        // Am adaugat manual sa vad daca merge
        friendList.add(new Friend(R.drawable.profile,"Friend_1"));
        friendList.add(new Friend(R.drawable.profile,"Friend_2"));
        friendList.add(new Friend(R.drawable.profile,"Friend_3"));
        friendList.add(new Friend(R.drawable.profile,"Friend_4"));

        adapter = new FriendAdapter(getActivity(), friendList);
        recyclerView.setAdapter(adapter);
    }
}
