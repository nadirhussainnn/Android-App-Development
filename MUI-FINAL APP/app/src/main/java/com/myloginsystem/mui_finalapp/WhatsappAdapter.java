package com.myloginsystem.mui_finalapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class WhatsappAdapter  extends ArrayAdapter<Users>{

    private final Activity context;
    List<Users> users;

    public WhatsappAdapter(@NonNull Activity context, int resource, @NonNull List<Users> objects) {
        super(context, resource, objects);
        this.context = context;
        this.users=objects;
    }


    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();

        View rowView=inflater.inflate(R.layout.whatsapp_item_view, null,true);

        ImageView imageView=rowView.findViewById(R.id.profileImageListItm);
        TextView nameView = (TextView) rowView.findViewById(R.id.usernameListItem);
        TextView lastMessage = (TextView) rowView.findViewById(R.id.lastMessageListItem);

        Users user= this.users.get(position);

        imageView.setImageResource(user.getProfileImage());
        nameView.setText(user.getName());
        lastMessage.setText(user.getLastMessage());
        return rowView;
    }

}