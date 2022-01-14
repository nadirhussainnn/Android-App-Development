package com.myloginsystem.mid2_labexam;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class AlarmReceiver extends BroadcastReceiver {

    int id=1;

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals("manage.alarm")){
            String channel_name="notf";
            String channel_id="notf1";

            NotificationManager manager=(NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);

            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
                NotificationChannel channel=new NotificationChannel(channel_id,channel_name,NotificationManager.IMPORTANCE_HIGH);
                channel.setShowBadge(true);
                manager.createNotificationChannel(channel);
            }

            NotificationCompat.Builder builder=new NotificationCompat.Builder(context,channel_id);

            Notification notification=builder.setContentTitle("ALARM")
                    .setContentText("WAKE UP! WAKE UP!")
                    .setSmallIcon(R.drawable.ic_baseline_access_alarm_24)
                    .build()
                    ;
            manager.notify(id,notification);
            id++;
        }
    }
}