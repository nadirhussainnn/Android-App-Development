package com.myloginsystem.alarmmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter=new IntentFilter();

        //registerReceiver(new MyReceiver(),intentFilter);

    }


    public void setAlarm(View view) {
        //1. Create AlarmManager object

        alarmManager=(AlarmManager) getSystemService(ALARM_SERVICE);

        //2. We have top display notification as well as open our app at that time

        //2.1 Create intent for receiver

        Intent intent=new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this,0,intent,0);


        //2.2 Create pending intent for activity to open it

        Intent intent1=new Intent(this, MainActivity.class);

        PendingIntent pendingIntent1=PendingIntent.getActivity(this,0,intent1,0);

        alarmManager.set(AlarmManager.RTC_WAKEUP,3*1000,pendingIntent);
        //RTC_WAKEUP: Runs even when device is off
    }
}