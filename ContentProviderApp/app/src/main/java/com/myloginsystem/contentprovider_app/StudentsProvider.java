package com.myloginsystem.contentprovider_app;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;

import java.util.HashMap;

public class StudentsProvider extends ContentProvider {

    static final String AUTHORITY="com.student.provider";    //Which you provided while creating ContentProvider
    static final String PATH="students";
    static final String PROVIDER_URL="content://"+AUTHORITY+"/"+PATH;
    static final Uri CONTENT_URI=Uri.parse(PROVIDER_URL);

    static final UriMatcher uriMatcher;

    static final int uriCode=1;

    static final int student_id=2;

    private SQLiteDatabase db;

    static final String id="id";            //schema variables
    static final String name="name";

    private static HashMap<String, String> values;

    static {
        // to match the content URI
        // every time user access table under content provider
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);

        //To access whole table, client app must call this path
        uriMatcher.addURI(AUTHORITY,"students",uriCode);

        //To access particular record, client ap must call this path
        uriMatcher.addURI(AUTHORITY,"students/#",student_id);

    }

    @Override
    public boolean onCreate() {

        Context context=getContext();
        DBHelper helper=new DBHelper(context);
        db=helper.getWritableDatabase();
        if(db!=null){
            return true;
        }
        return false;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.

        //Because we need to return number of rows deleted so
        int count=0;
        switch (uriMatcher.match(uri)){
            //Match that client has called correct path to our provider
            case uriCode:
                count=db.delete(DBHelper.TABLE_NAME,selection,selectionArgs);
                break;

            default:
                throw new IllegalArgumentException("INCORRECT QUERY");
        }

        getContext().getContentResolver().notifyChange(uri,null);//updates content provider to reflect new changes
        return count;
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data

        switch (uriMatcher.match(uri)){
            //get all students
            case uriCode:
                return "vnd.android.cursor.dir/vnd.example.students";
                //Get particular student
            case student_id:
                return "vnd.android.cursor.item/vnd.example.students";
             default:
                throw new IllegalArgumentException("INCORRECT QUERY");
        }

    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        // TODO: Implement this to handle requests to insert a new row.
        long row=db.insert(DBHelper.TABLE_NAME,"",values);

        if(row>0){
            Uri uri1= ContentUris.withAppendedId(CONTENT_URI,row);
            getContext().getContentResolver().notifyChange(uri,null);
            return uri1;
        }
        throw new IllegalArgumentException("FAILED TO ADD");
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        // TODO: Implement this to handle query requests from clients.
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();
        qb.setTables(DBHelper.TABLE_NAME);
        switch (uriMatcher.match(uri)) {
            case uriCode:
                qb.setProjectionMap(values);
                break;
            case student_id:
                qb.appendWhere( id + "=" + uri.getPathSegments().get(1));
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        if (sortOrder == null || sortOrder == "") {
            sortOrder = name;
        }
        Cursor c = qb.query(db, projection, selection, selectionArgs, null,
                null, sortOrder);
        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.

        int count = 0;
        switch (uriMatcher.match(uri)) {
            case uriCode:
                count = db.update(DBHelper.TABLE_NAME, values, selection, selectionArgs);
                break;
            case student_id:
                count = db.update(DBHelper.TABLE_NAME, values,
                        id + " = " + uri.getPathSegments().get(1) +
                                (!TextUtils.isEmpty(selection) ? " AND (" +selection + ')' : ""), selectionArgs);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);
        return count;
    }
}