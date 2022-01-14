package com.myloginsystem.mid2_practice;

import android.content.Context;
import android.graphics.Color;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<UserModel> {

    ContextualActionModeActivity context;
    List<UserModel> users;
    int list_item;

    private ActionMode actionMode;
    View v=null;
    public UserAdapter(@NonNull ContextualActionModeActivity context, int list_item, @NonNull List<UserModel> users) {
        super(context, list_item, users);
        this.context=context;
        this.users=users;
        this.list_item=list_item;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater=context.getLayoutInflater();

        if(layoutInflater==null){
            v=layoutInflater.inflate(list_item,null, true);
        }

        ImageView userProfileImage=v.findViewById(R.id.profileImage);
        TextView userName=v.findViewById(R.id.userName);

        UserModel user=users.get(position);

        userProfileImage.setImageResource(user.getProfileImage());
        userName.setText(user.getUserName());

//        v.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//
//                if(actionMode!=null){
//                    v.setBackgroundColor(Color.WHITE);
//                    return false;
//                }
//                actionMode=context.startActionMode(actionModeCallback);
//                v.setSelected(true);
//                v.setBackgroundColor(Color.GRAY);
//                return true;
//            }
//        });

        return v;
    }

    private ActionMode.Callback actionModeCallback=new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater=mode.getMenuInflater();
            inflater.inflate(R.menu.contextual_action_mode_behavior_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {

            int id=item.getItemId();
            Toast.makeText(context, "ID "+id, Toast.LENGTH_SHORT).show();
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            actionMode=null;
        }
    };
}