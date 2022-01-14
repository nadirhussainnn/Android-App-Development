package com.myloginsystem.broadcast_receivers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("com.example.myBroadcast");
        intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
        registerReceiver(new FirstReceiver(),intentFilter);

    }

    public void broadcastAction(View view) {
        Intent intent=new Intent();
        intent.setAction("com.example.myBroadcast");
        intent.putExtra("name","Nadir Hussain");
        sendBroadcast(intent);
    }
}