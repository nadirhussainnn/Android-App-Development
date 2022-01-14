package com.myloginsystem.contentconsumer_contentproviderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText studentName;
    static final String AUTHORITY="com.student.provider";   //Provider AUTHORITY
    static final String PATH="students";

    Uri content_provider_uri= Uri.parse("content://"+AUTHORITY+"/"+PATH);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentName=findViewById(R.id.studentName);

    }

    public void addStudent(View view) {

        ContentValues contentValues=new ContentValues();
        contentValues.put("name",studentName.getText().toString());

        getContentResolver().insert(content_provider_uri,contentValues);

    }


    @SuppressLint("Range")
    public void loadStudents(View view) {

        TextView resultView= (TextView) findViewById(R.id.res);

        Cursor cursor = getContentResolver().query(Uri.parse("content://"+AUTHORITY+"/"+PATH), null, null, null, null);

        StringBuilder strBuild=new StringBuilder();

        if(cursor!=null){
            if(cursor.getCount()>0){
                cursor.moveToFirst();
                do{
                    strBuild.append("\n"+cursor.getString(cursor.getColumnIndex("id"))+ "-"+ cursor.getString(cursor.getColumnIndex("name")));
                }
                while (cursor.moveToNext());
                resultView.setText(strBuild);
            }
        }
    }

}