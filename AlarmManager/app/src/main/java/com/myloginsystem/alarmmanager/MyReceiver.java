package com.myloginsystem.alarmmanager;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {

    String CHANNEL_ID="1234";
    String CHANNEL_NAME="Channel1";
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent scheduledIntent = new Intent(context, MainActivity.class);
        scheduledIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(scheduledIntent);

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
//
//            NotificationChannel channel=new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
//            NotificationManager manager= (NotificationManager)context.getSystemService(context.NOTIFICATION_SERVICE);
//            manager.createNotificationChannel(channel);
//
//            PendingIntent pendingIntent=PendingIntent.getActivity(context,0,intent,0);
//
//
//            NotificationCompat.Builder builder=new NotificationCompat.Builder(context,CHANNEL_ID)
//                    .setContentTitle("My Service Notification")
//                    .setContentText("Wooowooowooo")
//                    .setSmallIcon(R.drawable.ic_baseline_alarm_24)
//                    .setContentIntent(pendingIntent)
//                    ;
//
//            Notification notification=builder.build();
//            manager.notify(1234,notification);
//        }
    }
}