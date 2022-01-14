package com.myloginsystem.mid2_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ContextualActionModeActivity extends AppCompatActivity {

    ArrayList<UserModel> users;
    ListView listView;
    UserAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contextual_action_mode);

        listView=findViewById(R.id.userListView);
        users=new ArrayList<UserModel>();

        populateList();

        adapter=new UserAdapter(this, R.layout.list_item, users);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        listView.setAdapter(adapter);
    }

    private void populateList() {
        UserModel userModel;

        userModel=new UserModel();
        userModel.setUserName("Nadir Hussain");
        userModel.setProfileImage(R.drawable.a);
        users.add(userModel);

        userModel=new UserModel();
        userModel.setUserName("Zeeshan Ahmed");
        userModel.setProfileImage(R.drawable.b);
        users.add(userModel);

        userModel=new UserModel();
        userModel.setUserName("Noman Aijaz");
        userModel.setProfileImage(R.drawable.c);
        users.add(userModel);

        userModel=new UserModel();
        userModel.setUserName("Sayed Rizwan");
        userModel.setProfileImage(R.drawable.d);
        users.add(userModel);

        userModel=new UserModel();
        userModel.setUserName("Hans Raj");
        userModel.setProfileImage(R.drawable.b);
        users.add(userModel);
    }
}