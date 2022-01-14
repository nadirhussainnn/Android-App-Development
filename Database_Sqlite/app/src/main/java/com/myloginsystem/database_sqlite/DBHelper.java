package com.myloginsystem.database_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

    private static final int VERSION=1;             //must be static
    private static final String DBNAME="TEACHERS";  //must be static
    private static final String TABLE1="EMPLOYEES";

    public DBHelper(Context context){
        super(context,DBNAME,null, VERSION);

        //context, database name, Cursorfactory and version
        /*
        * WHAT IS VERSION: Android provides mechanism to upgrade and downgrade the database
        * Useful when app behaves badly due to database changes we can rollback or downgrade
        * */
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        //Called for First Version, we can't upgrade database with same version. It is not called for new Version
        // Adding table, schema etc  can change Database
        // One time work must be performed here: Exp create table, fetch data for table and insert

        String usersTable="CREATE TABLE IF NOT EXISTS EMPLOYEES(" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "NAME TEXT, " +
                "AGE INTEGER)";

        db.execSQL(usersTable);
        ContentValues content=new ContentValues();
        content.put("NAME","Zakir");
        content.put("AGE",9);

        int resp=(int)db.insert(TABLE1,null,content);
        if(resp>0){
            return;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //CALLED when VERSION is changed
    }

    public Cursor findUserById(int ID){
        //Android provides 2 methods to get reference of db here. Applicable in OpenHelper only
        SQLiteDatabase db=getReadableDatabase();
        String query="SELECT * FROM "+TABLE1+" WHERE ID='"+ID+"'";
        Cursor data=db.rawQuery(query,null);
        return data;
    }
}