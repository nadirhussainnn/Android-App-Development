package com.myloginsystem.foregroundservices;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("my.receiver.1")){
            Toast.makeText(context, "Happened", Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals("android.intent.action.SCREEN_ON")){
            Toast.makeText(context, "SCREEN IS ON BETA", Toast.LENGTH_SHORT).show();
        }
    }
}