package com.myloginsystem.usingmuicomponents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.MaterialToolbar;

public class Navigation_Drawer extends AppCompatActivity {


    MaterialToolbar topAppBar;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation__drawer);
        getSupportActionBar().hide();
        topAppBar=findViewById(R.id.topAppBar);
        drawerLayout=findViewById(R.id.drawer);
        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.open();
            }
        });
    }
}