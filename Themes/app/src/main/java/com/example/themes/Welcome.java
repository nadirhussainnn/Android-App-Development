package com.example.themes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListPopupWindow;
import android.widget.ListView;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Welcome extends AppCompatActivity {

    TopFragment topFragment;
    BottomFragment bottomFragment;
    FragmentManager manager;
    FragmentTransaction transaction;
    TopRoundedFragment topRoundedFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

       topFragment = new TopFragment();
       bottomFragment= new BottomFragment();
       topRoundedFragment= new TopRoundedFragment();

       manager= getSupportFragmentManager();
       transaction= manager.beginTransaction();

       transaction.add(R.id.topFragemnet,topRoundedFragment,"Top Fragemnet");
       transaction.add(R.id.bottomFragemnet,bottomFragment,"Bottom Fragemnet");

       transaction.commit();


    }
}