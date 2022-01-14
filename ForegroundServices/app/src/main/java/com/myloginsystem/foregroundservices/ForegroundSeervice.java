package com.myloginsystem.foregroundservices;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class ForegroundSeervice extends Service {

    final String CHANNEL_NAME="MY_CHANNEL";
    final String CHANNEL_ID="1234";

    @Nullable
//    Deprecated method
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

//    Called when service is created, perform service task/ background task here exp: Downloading, song playing etc
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);


        //return 0;//Will give error, bcz it expects type of service
        /*
        * Service_types
        * 1. START_STICKY       : When app is killed, service is killed but START_STICKY keeps the service alive.
        * 2. START_NO_STICKY    : We kill processes/services when app is killed,
        *
        * Components must be explained in manifest, so we do that for this service
        *
        *
        * Foreground service must show statusbar notification to user .
        * */

        //1. Create channel

        createChannel();

        //2. Create pending intent

        Intent intent1=new Intent(getApplicationContext(),MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,intent1,0);

        //3. Create notification
        NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID)
                .setContentTitle("My Service Notification")
                .setContentText("Wooowooowooo")
                .setSmallIcon(R.drawable.ic_baseline_4g_mobiledata_24)
                .setContentIntent(pendingIntent)
                ;

        Notification notification=builder.build();

        //4. start service

        startForeground(1234,notification);

        return START_NOT_STICKY;
    }

    public void createChannel(){

        /*
        * WHY CREATE CHANNEL?
        *
        * > Application need to group notification, exp whatsapp shows 1 notification for all chats
        * earlier, apps displayed new notification for every msg. Channel
        * > Mobile user can manage Notification channel, exp for whatsapp we can hide and change only it's notification
        * settings, without modifying other.
        *
        * */

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel=new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            //channel.setVibrationPattern();
            //
            //channel.setShowBadge();
            manager.createNotificationChannel(channel);
        }
    }
}