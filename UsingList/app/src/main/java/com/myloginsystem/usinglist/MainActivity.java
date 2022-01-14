package com.myloginsystem.usinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Users> users;
    MyAdapter adapter;
    EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        users=new ArrayList<>();
        text=findViewById(R.id.text);

        Users user;

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Nadir Hussain");
        user.setName("hi janu");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.bhai);
        user.setName("Sajjad Hussain");
        user.setName("hi kuku");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setName("hello");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setName("hello");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setName("hello");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setName("hello");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setName("hello");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setName("hello");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setLastMsg("hello");
        users.add(user);

        user=new Users();
        user.setProfileImage(R.drawable.abc);
        user.setName("Kashif Hussain");
        user.setName("hello");
        users.add(user);

        adapter=new MyAdapter(this, R.layout.list_item,users);

        listView=findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }

    public void addRecord(View v){

     Users u=new Users();
     u.setProfileImage(R.drawable.bhai);
     u.setName(text.getText().toString());
     u.setLastMsg("janu");

     users.add(u);
     adapter.setNotifyOnChange(true);
    }
}