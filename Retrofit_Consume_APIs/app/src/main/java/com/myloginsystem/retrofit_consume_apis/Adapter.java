package com.myloginsystem.retrofit_consume_apis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {


    List<RecycleItemModel> users;

    public Adapter(List<RecycleItemModel> users) {
        this.users=users;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {

        int profileImage=users.get(position).getProfileImage();
        String userName=users.get(position).getUserName();
        String lastMessage=users.get(position).getLastMessage();
        String lasteMessageTime=users.get(position).getMessageTime();

        holder.setData(profileImage, userName, lastMessage, lasteMessageTime);
    }

    @Override
    public int getItemCount() {

        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView profileImage;
        private TextView user, msg, time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            profileImage=itemView.findViewById(R.id.profileImage);
            user=itemView.findViewById(R.id.title);
            msg=itemView.findViewById(R.id.message);
            time=itemView.findViewById(R.id.messageTime);

        }
        public void setData(int profileImg, String userName, String lastMessage, String lasteMessageTime) {
            profileImage.setImageResource(profileImg);
            user.setText(userName);
            msg.setText(lastMessage);
            time.setText(lasteMessageTime);
        }
    }
}
