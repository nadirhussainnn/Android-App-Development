package com.myloginsystem.usinglist;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter  extends ArrayAdapter<Users> {

    Activity context;
    List<Users> list;
    public MyAdapter(@NonNull Activity context, int resource, @NonNull List<Users> objects) {
        super(context, resource, objects);
        this.list=objects;
        this.context=context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item, null, true);

        ImageView img=v.findViewById(R.id.profileImage);
        TextView name=v.findViewById(R.id.userName);
        TextView msg=v.findViewById(R.id.lastMsg);

        Users user=list.get(position);

        name.setText(user.getName());
        img.setImageResource(user.getProfileImage());
        msg.setText(user.getLastMsg());

        return  v;
    }
}
