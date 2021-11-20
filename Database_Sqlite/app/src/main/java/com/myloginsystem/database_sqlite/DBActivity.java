package com.myloginsystem.database_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class DBActivity extends AppCompatActivity {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_b);

    }

    public void createDB(View v){
        db=openOrCreateDatabase("students",MODE_PRIVATE,null);
        String usersTable="CREATE TABLE users(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "AGE INTEGER)";
        db.execSQL(usersTable);

        //ADB: Android Debug bridge Tool used to connect device and android studio, exp it shows errors on android studio
        // instead of Mobile/device.
        // Database is created on Physical device so we need to connect our physical device to get data

        Toast.makeText(this, "Created Table", Toast.LENGTH_SHORT).show();
    }
    public void insert(View v){}
    public void update(View v){}
    public void delete(View v){}
    public void select(View v){}
}