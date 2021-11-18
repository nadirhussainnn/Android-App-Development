package com.myloginsystem.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showListView(View v){
        Intent intent=new Intent(this, ListViewActivity.class);
        startActivity(intent);

    }
    public void showRecycleView(View v){

        Intent intent=new Intent(this, RecycleViewActivity.class);
        startActivity(intent);
    }
}