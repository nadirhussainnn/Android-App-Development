package com.myloginsystem.database_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

        DBHelper dbHelper=new DBHelper(this);

        Cursor cursor=dbHelper.findUserById(1);
        Toast.makeText(this, ""+cursor.toString(), Toast.LENGTH_SHORT).show();
        cursor.moveToFirst();
        String name="";
        while (cursor.moveToNext()){
            name+=cursor.getString(1);
        }
        Toast.makeText(this, ""+name, Toast.LENGTH_SHORT).show();

        //For insert, update, fetch and delete we need to create methods in DBHelper
    }

    public void createDB(View v){
        db=openOrCreateDatabase("students",MODE_PRIVATE,null);
        String usersTable="CREATE TABLE IF NOT EXISTS USERS(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "AGE INTEGER)";
        db.execSQL(usersTable);

        //ADB: Android Debug bridge Tool used to connect device and android studio, exp it shows errors on android studio
        // instead of Mobile/device.
        // Database is created on Physical device so we need to connect our physical device to get data

        Toast.makeText(this, "Created Table", Toast.LENGTH_SHORT).show();
    }
    public void insert(View v){

        //Way 1
        String query="INSERT INTO USERS(NAME, AGE) VALUES('Nadir Hussain',21)";
        db.execSQL(query);

        //Way 2
        ContentValues content=new ContentValues();
        //It is a key-value pair, column and value
        content.put("NAME","Zakir");
        content.put("AGE",9);

        int resp=(int)db.insert("Users",/*Name of Column which is NULL*/null,content);
        if(resp>0){
            Toast.makeText(this, "INSERTED", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, "ERROR OCCURED", Toast.LENGTH_SHORT).show();
    }
    public void select(View v){

        String query="SELECT * FROM USERS";
        Cursor data=db.rawQuery(query, null);
        //2nd arg is data that we want to send as ? filler

        data.moveToFirst();
        String records="";

        do{
            records+=data.getInt(0)+"\n";
            records+=data.getString(1)+"\n";
            records+=data.getInt(2)+"\n-----------------------\n";
        }while (data.moveToNext());

        Toast.makeText(this, "Data "+records, Toast.LENGTH_SHORT).show();
    }
    public void update(View v){
        String query="UPDATE USERS SET NAME='Ali' WHERE NAME='Zakir'";
        db.execSQL(query);

        Toast.makeText(this, "UPDATED", Toast.LENGTH_SHORT).show();
    }

    public void delete(View v){

        String query="DELETE FROM USERS";
        db.execSQL(query);

        Toast.makeText(this, "DELETED", Toast.LENGTH_SHORT).show();

        /**/
//        db.beginTransaction();
//
//        db.endTransaction();
    }
}