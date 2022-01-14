package com.myloginsystem.mid2_labexam;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Calendar;
import java.util.List;

public class DataAdapter extends ArrayAdapter<DataModel> {

    MainActivity context;
    List<DataModel> list;

    AlarmManager alarmManager;
    PendingIntent pendingIntent;


    public DataAdapter(@NonNull MainActivity context, int resource, List<DataModel> list) {
        super(context, resource, list);
        this.list=list;
        this.context=context;

        getAlarm();

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.list_item, null,false);

        DataModel data=list.get(position);

        TextView day=v.findViewById(R.id.dayText);
        TextView start=v.findViewById(R.id.dayStartTime);
        TextView end=v.findViewById(R.id.dayEndTime);
        CheckBox checkBox=v.findViewById(R.id.dayCheckBox);
        Button btn=v.findViewById(R.id.dayBtn);

        day.setText(data.getDay());
        start.setText(data.getStartTime());
        end.setText(data.getEndTime());
        btn.setText(data.getBtnText());
        checkBox.setChecked(data.getCheckStatus());

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){

                    String pm_time=end.getText().toString();
                    setRepeatingAlarm(pm_time, data.getDay());
                }
                else{
                    removeRepeatingAlarm();
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String pm_time=end.getText().toString();
                String before=btn.getText().toString();

                if(before.equals("ON")){
                    btn.setText("OFF");
                    removeAlarm();
                }
                else{
                    btn.setText("ON");
                    setAlarm(pm_time,data.getDay());
                }
            }
        });

        return v;
    }

    public void setRepeatingAlarm(String pm, String day){

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());

        setDay(calendar, day);

        int hour=getHour(pm);
        int mint=getMinute(pm);

        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,mint);
        calendar.set(Calendar.SECOND,0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 1000*60*5, pendingIntent);
    }

    public void setAlarm(String pm, String day){

        Calendar calendar=Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        setDay(calendar, day);

        int hour=getHour(pm);
        int mint=getMinute(pm);

        calendar.set(Calendar.HOUR_OF_DAY,hour);
        calendar.set(Calendar.MINUTE,mint);
        calendar.set(Calendar.SECOND,0);
        calendar.set(Calendar.AM_PM, Calendar.PM);

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*60*5,pendingIntent);
    }

    public void removeRepeatingAlarm(){

        alarmManager.cancel(pendingIntent);
    }

    public void removeAlarm(){
        alarmManager.cancel(pendingIntent);
    }


    public void setDay(Calendar calendar,String day){
        if(day.equals("Mon")){
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.MONDAY);
        }else if(day.equals("Tue")){
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.TUESDAY);
        }
        else if(day.equals("Wed")){
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.WEDNESDAY);
        }
        else if(day.equals("Thu")){
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.THURSDAY);
        }
        else if(day.equals("Fri")){
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
        }
        else if(day.equals("Sat")){
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.SATURDAY);
        }
        else if(day.equals("Sun")){
            calendar.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
        }
    }

    public int getHour(String pm){

        String[] hour=pm.split(":");
        return Integer.parseInt(hour[0]);
    }

    public int getMinute(String pm){

        String[] min=pm.split(":");
        return Integer.parseInt(min[1]);
    }

    public void getAlarm(){
        alarmManager=(AlarmManager)context.getSystemService(context.ALARM_SERVICE);
        Intent intent=new Intent(context, AlarmReceiver.class);
        pendingIntent=PendingIntent.getBroadcast(context,0,intent,0);
    }
}
