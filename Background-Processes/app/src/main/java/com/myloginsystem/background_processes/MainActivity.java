package com.myloginsystem.background_processes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.net.IDN;


//Immediate Execution: Using Threads
//When program terinates, thread is killed in Immediate Execution

public class MainActivity extends AppCompatActivity {


    TextView timerLabel;
    Button playBtn, pauseBtn, showNotfBtn;
    int secs, mins, hours;
    Thread thread;

    String CHANNEL_ID="CH_123";
    String CHANNEL_NAME="MY CHANNEL";

    //TO display battery level
//    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
//        @Override
//        public void onReceive(Context ctxt, Intent intent) {
//            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
//            float batteryPct = level * 100 / (float)scale;
//            timerLabel.setText(String.valueOf(batteryPct) + "%");
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerLabel=findViewById(R.id.timeLabel);
        playBtn=findViewById(R.id.playBtn);
        pauseBtn=findViewById(R.id.pauseBtn);
        showNotfBtn=findViewById(R.id.showNotfs);

        secs=mins=hours=0;
        timerLabel.setText(hours+" : "+mins+" : "+secs);
//        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                secs++;

                //WAY1: Updating UI Thread from other Thread using View.post method
                thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=0;i<60;i++) {
                            secs++;
                            if(secs>=59){
                                secs=0;
                                mins++;
                            }
                            if(mins>=59){
                                hours++;
                            }
                            timerLabel.post(new Runnable() {
                                @Override
                                public void run() {
                                    timerLabel.setText(hours + " : " + mins + " : " + secs);
                                }
                            });
                            try {
                                Thread.sleep(1000);
                            }catch (Exception ex){

                            }
                        }
                    }
                });

//                WAY2: Updating UI Thread from other Thread using View.post method
//                Thread thread=new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                timerLabel.setText(hours+" : "+mins+" : "+secs);
//                            }
//                        });
//                    }
//                });

                //WAY3: Using Handler, used for message passing bw multiple Threads exp:
                // While Downloading we can play music, on threads downloads, informs to other and other plays music

                Handler handler=new Handler();

//                Thread thread=new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        handler.post(new Runnable() {
//                            @Override
//                            public void run() {
//                                timerLabel.setText(hours+" : "+mins+" : "+secs);
//                            }
//                        });
//                    }
//                });


                thread.start();
            }
        });
        pauseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        showNotfBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                BatteryManager bm = (BatteryManager) getApplicationContext().getSystemService(BATTERY_SERVICE);
                int batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
                timerLabel.setText(batLevel+"");

                NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

                // Creating Pending Intent
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                PendingIntent pendingIntent=PendingIntent.getActivity(getApplicationContext(),0,intent,0);
                //Parametres:context
                //requestcode: 0, Always 0
                //intent
                //flags:0


                //Creating Notification actions
                NotificationCompat.Action action=new NotificationCompat.Action(R.drawable.ic_home,"OPEN BTN",null);

                NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext(),CHANNEL_ID).
                        setContentTitle("Whatspp Message").
                        setContentText("Nadir sent you message").
                        setSmallIcon(R.drawable.ic_home).
                        setAutoCancel(true).
                        setContentIntent(pendingIntent).
                        addAction(action);


                Notification notification=builder.build();

                if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
                    NotificationChannel notificationChannel=new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
                    notificationManager.createNotificationChannel(notificationChannel);
                    notificationManager.notify(1234,notification);
                }
            }
        });
    }
}


//Showing Notifications from Background to UI, even when app is not running.

//
//public class Main extends Activity {
//    private TextView batteryTxt;
//    private BroadcastReceiver mBatInfoReceiver = new BroadcastReceiver(){
//        @Override
//        public void onReceive(Context ctxt, Intent intent) {
//            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
//            int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
//            float batteryPct = level * 100 / (float)scale;
//            batteryTxt.setText(String.valueOf(batteryPct) + "%");
//        }
//    };
//
//    @Override
//    public void onCreate(Bundle b) {
//        super.onCreate(b);
//        setContentView(R.layout.main);
//        batteryTxt = (TextView) this.findViewById(R.id.batteryTxt);
//        this.registerReceiver(this.mBatInfoReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
//    }
//}