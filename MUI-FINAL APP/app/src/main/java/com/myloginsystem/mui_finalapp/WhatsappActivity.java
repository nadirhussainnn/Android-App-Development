package com.myloginsystem.mui_finalapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Switch;

import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;
import java.util.List;

public class WhatsappActivity extends AppCompatActivity {

    ListView chatList;
    WhatsappAdapter adapter;
    ArrayList<Users> users;


    MaterialToolbar appbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        users=new ArrayList<Users>();
        chatList=findViewById(R.id.chatListView);
        appbar=findViewById(R.id.whatsappAppBar);

        Users user=new Users();

        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);

        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);

        user=new Users();
        user.setName("Nadir Hussain");
        user.setLastMessage("Nadir Hussain");
        user.setTime("10:45PM");
        user.setProfileImage(R.drawable.profileimg);
        users.add(user);


        adapter=new WhatsappAdapter(this,R.layout.whatsapp_item_view,users);
        chatList.setAdapter(adapter);

        appbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id=item.getItemId();
                switch (id){
                    case R.id.whatsappHomeItem:
                        Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                        break;

                    default:
                        return false;
                }
                return false;
            }
        });
    }
}