package com.myloginsystem.recycleview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    private List<RecycleItemModel> userList;

    public Adapter(List<RecycleItemModel> list){
        this.userList=list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item, parent, false);
        return new ViewHolder(view);
     }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        int profileImage=userList.get(position).getProfileImage();
        String userName=userList.get(position).getUserName();
        String lastMessage=userList.get(position).getLastMessage();
        String lastMessageTime=userList.get(position).getLastMessageTime();

        holder.setData(profileImage, userName, lastMessage, lastMessageTime);

    }

    @Override
    public int getItemCount() {

        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView profileImage;
        private TextView userName;
        private TextView lastMessage;
        private TextView lastMessageTime;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage=itemView.findViewById(R.id.profileImage);
            userName=itemView.findViewById(R.id.userName);
            lastMessage=itemView.findViewById(R.id.lastMessage);
            lastMessageTime=itemView.findViewById(R.id.msgTime);

        }

        public void setData(int pImage, String uName, String lMessage, String lMessageTime) {
            profileImage.setImageResource(pImage);
            userName.setText(uName);
            lastMessageTime.setText(lMessageTime);
            lastMessage.setText(lMessage);
        }
    }
}
