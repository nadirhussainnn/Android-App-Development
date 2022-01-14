package com.myloginsystem.mid2_labexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    DataAdapter adapter;
    ArrayList<DataModel> dataModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("manage.alarm");
        AlarmReceiver receiver=new AlarmReceiver();
        registerReceiver(receiver, intentFilter);


        dataModel=new ArrayList<>();

        populateList();

        listView=findViewById(R.id.listView);
        adapter=new DataAdapter(this, R.layout.list_item, dataModel);
        listView.setAdapter(adapter);

    }

    public void populateList(){

        DataModel dataModel;
        dataModel=new DataModel();
        dataModel.setDay("Mon");
        dataModel.setStartTime("9:00:AM");
        dataModel.setEndTime("2:30:PM");
        dataModel.setBtnText("OFF");
        dataModel.setCheckStatus(true);
        this.dataModel.add(dataModel);

        dataModel=new DataModel();
        dataModel.setDay("Tue");
        dataModel.setStartTime("9:00 AM");
        dataModel.setEndTime("10:00 AM");
        dataModel.setBtnText("OFF");
        dataModel.setCheckStatus(false);
        this.dataModel.add(dataModel);

        dataModel=new DataModel();
        dataModel.setDay("Wed");
        dataModel.setStartTime("9:00 AM");
        dataModel.setEndTime("10:00 AM");
        dataModel.setBtnText("OFF");
        dataModel.setCheckStatus(false);
        this.dataModel.add(dataModel);

        dataModel=new DataModel();
        dataModel.setDay("Thu");
        dataModel.setStartTime("9:00 AM");
        dataModel.setEndTime("10:00 AM");
        dataModel.setBtnText("OFF");
        dataModel.setCheckStatus(false);
        this.dataModel.add(dataModel);

        dataModel=new DataModel();
        dataModel.setDay("Fri");
        dataModel.setStartTime("9:00 AM");
        dataModel.setEndTime("10:00 AM");
        dataModel.setBtnText("OFF");
        dataModel.setCheckStatus(false);
        this.dataModel.add(dataModel);

        dataModel=new DataModel();
        dataModel.setDay("Sat");
        dataModel.setStartTime("9:00 AM");
        dataModel.setEndTime("10:00 AM");
        dataModel.setBtnText("ON");
        dataModel.setCheckStatus(true);
        this.dataModel.add(dataModel);

        dataModel=new DataModel();
        dataModel.setDay("Sun");
        dataModel.setStartTime("9:00 AM");
        dataModel.setEndTime("10:00 AM");
        dataModel.setBtnText("OFF");
        dataModel.setCheckStatus(true);
        this.dataModel.add(dataModel);
    }
}