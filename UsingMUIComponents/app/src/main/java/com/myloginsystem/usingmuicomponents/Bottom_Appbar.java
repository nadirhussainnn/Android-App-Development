package com.myloginsystem.usingmuicomponents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Bottom_Appbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom__navigation);
        getSupportActionBar().hide();
    }
}