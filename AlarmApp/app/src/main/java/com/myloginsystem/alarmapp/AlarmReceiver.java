package com.myloginsystem.alarmapp;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;



public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            context.startForegroundService(new Intent(context, AlarmSoundService.class));
            context.startForegroundService(new Intent(context, AlarmNotificationService.class));
        }
        else{
            context.startService(new Intent(context, AlarmSoundService.class));
            context.startService(new Intent(context, AlarmNotificationService.class));
        }

    }
}
