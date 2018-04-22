package com.example.rober.flashbox;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder>{

    private Context myctx;
    private List<Friend> friendList;

    public FriendAdapter(Context myctx, List<Friend> friendList) {
        this.myctx = myctx;
        this.friendList = friendList;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(myctx);
        View view = inflater.inflate(R.layout.friend_card, null);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        Friend friend = friendList.get(position);

        holder.textViewName.setText(friend.getName());
        holder.imageViewAvatar.setImageDrawable(myctx.getResources().getDrawable(friend.getAvatar()));
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }

    class FriendViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewAvatar;
        TextView textViewName;

        public FriendViewHolder(View itemView) {
            super(itemView);

            imageViewAvatar = itemView.findViewById(R.id.friend_avatar);
            textViewName = itemView.findViewById(R.id.friend_name);
        }
    }
}