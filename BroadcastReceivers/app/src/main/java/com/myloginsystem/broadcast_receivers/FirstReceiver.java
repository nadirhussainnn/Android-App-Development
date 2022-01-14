package com.myloginsystem.broadcast_receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class FirstReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("com.example.myBroadcast")){
            Toast.makeText(context, "MY ACTION "+intent.getStringExtra("name"), Toast.LENGTH_SHORT).show();
        }
        else if(intent.getAction().equals("android.intent.action.AIRPLANE_MODE")){
            Toast.makeText(context, "AERO PLANE MODE", Toast.LENGTH_SHORT).show();
        }
    }
}