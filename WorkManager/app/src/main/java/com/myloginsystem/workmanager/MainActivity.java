package com.myloginsystem.workmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    WorkManager workManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startWorker(View view) {

        Constraints constraints = new Constraints.Builder()
                .setRequiredNetworkType(NetworkType.UNMETERED)
                .setRequiresCharging(true)
                .build();

        /*
        We set constraints to ensue that work is deferred until some conditions are met
        Such as DO NOT RUN WORK MANAGER ON LOW BATTERY

         */

        workManager=WorkManager.getInstance();
        OneTimeWorkRequest oneTimeWorkRequest=new OneTimeWorkRequest.Builder(UploadWorker.class)
                .setConstraints(constraints)
                .build();

        workManager.enqueue(oneTimeWorkRequest);

    }
}