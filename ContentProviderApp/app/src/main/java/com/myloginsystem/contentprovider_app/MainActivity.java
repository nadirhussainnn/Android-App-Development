package com.myloginsystem.contentprovider_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText studentName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentName=findViewById(R.id.studentNameText);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void onClickAddDetails(View view) {

        ContentValues values = new ContentValues();
        values.put("name", studentName.getText().toString());

        //bcz ID is auto incremented

        ContentResolver resolver=getContentResolver();
        resolver.insert(StudentsProvider.CONTENT_URI, values);

    }

    @SuppressLint("Range")
    public void onClickShowDetails(View view) {

        TextView resultView= (TextView) findViewById(R.id.res);

        // creating a cursor object of the
        // content URI
        Cursor cursor = getContentResolver().query(Uri.parse("content://"+StudentsProvider.AUTHORITY+"/"+StudentsProvider.PATH), null, null, null, null);

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