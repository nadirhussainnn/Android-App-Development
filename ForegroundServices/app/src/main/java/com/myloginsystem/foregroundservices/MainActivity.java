package com.myloginsystem.foregroundservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    Intent serviceIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("my.receiver.1");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        registerReceiver(new MyReceiver(),intentFilter);

    }

    public void clickMe(View view) {
        serviceIntent=new Intent(this,ForegroundSeervice.class);
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                startForegroundService(serviceIntent);
        }
        else{
            startService(serviceIntent);
        }
    }

    public void stopService(View view) {
        stopService(serviceIntent);
    }
}