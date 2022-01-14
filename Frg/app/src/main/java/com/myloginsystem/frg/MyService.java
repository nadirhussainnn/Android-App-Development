package com.myloginsystem.frg;


import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
public class MyService extends Service {
    @Nullable
    String CHANNEL_ID="123";
    String CHANNEL_NAME="WHATSAPP_CHANNEL";
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        super.onStartCommand(intent, flags, startId);

        //Create Notification channel
        createChannel();

        //Create Pending Intent
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

        //Build Notification
        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID)
                .setContentTitle("My Service Notification")
                .setContentText("Wooowooowooo")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pendingIntent)
                ;
        Notification notification=builder.build();

        //start service
        startForeground(1234,notification);
        return  START_NOT_STICKY;
    }
    public void createChannel(){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
        }
        else{

        }
    }
}
