package com.myloginsystem.mui_finalapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class WhatsappActivity extends AppCompatActivity {

    ListView chatList;
    WhatsappAdapter adapter;
    ArrayList<Users> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_whatsapp);

        users=new ArrayList<Users>();
        chatList=findViewById(R.id.chatListView);

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
    }
}