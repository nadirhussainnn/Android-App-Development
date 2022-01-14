package com.myloginsystem.customnotifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dispNotf(View view) {

        NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("1","1",NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        Intent intent=new Intent(this, MainActivity.class);
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intent,0);

        RemoteViews remoteViews=new RemoteViews(getPackageName(), R.layout.custom_notf_layout);

        Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.second);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"1")
                .setContentTitle("Hello Image")
                .setContentText("Wow ...")
                .setSmallIcon(R.drawable.ic_baseline_home_24)
                .setContentIntent(pendingIntent)
                //To display our own layout
                //.setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                //.setCustomContentView(remoteViews)

//                Adding an expandable large image that appears as icon when collapsed
                .setLargeIcon(bitmap)
                .setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null))

                //Adding a large expandable block of text
//                .setStyle(new NotificationCompat.BigTextStyle().bigText("Wow Lorem Epsum xyx  Lorem Epsum xyx  Lorem Epsum xyx  Lorem Epsum xyx  Lorem Epsum xyx"))

                //inbox-style notification
                .setStyle(new NotificationCompat.InboxStyle()
                .addLine("Notf1 subject")
                 .addLine("Notf body")
                )
                ;

        Notification notification=builder.build();

        notificationManager.notify(1,notification);
    }
}