package com.myloginsystem.singletierdb_app;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> students=null;
    ArrayAdapter<String> adapter;
    ListView list;
    EditText studentName, studentAge;

    SQLiteDatabase database;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        list=findViewById(R.id.studentList);
        studentName=findViewById(R.id.name);
        studentAge=findViewById(R.id.age);

        students=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this,R.layout.table_row, students);
        list.setAdapter(adapter);
        //Executed once
        createDatabaseSchema();

    }

    public void addStudent(View v){
        String name=studentName.getText().toString();
        int age=Integer.parseInt(studentAge.getText().toString());
        Boolean resp=addStudent(name,age);

        if(resp){
            String record=getIdForNewRecord()+"      "+name+"        "+age;
            students.add(record);
            adapter.notifyDataSetChanged();
            studentName.setText("");
            studentAge.setText("");
        }
        else
            Toast.makeText(this, "FAILED", Toast.LENGTH_SHORT).show();
    }

    public void showAllStudents(View v){
        getAllStudents();
    }
    public void deleteAllStudents(View v){
        deleteAllStudents();
    }
    public void updateStudent(View v){

        AlertDialog.Builder inputDialog=new AlertDialog.Builder(this);
        inputDialog.setTitle("Update Student");

        EditText id=new EditText(this);
        EditText name=new EditText(this);
        EditText age=new EditText(this);
        id.setHint("Enter Id of student");
        name.setHint("Enter New Name");
        age.setHint("Enter New Age");

        id.setInputType(InputType.TYPE_CLASS_NUMBER);
        name.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        age.setInputType(InputType.TYPE_CLASS_NUMBER);

        LinearLayout layout=new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(10,10,10,10);

        layout.addView(id);
        layout.addView(name);
        layout.addView(age);

        inputDialog.setView(layout);


        inputDialog.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String newName;
                int studentId, newAge;
                newName=name.getText().toString();
                studentId=Integer.parseInt(id.getText().toString());
                newAge=Integer.parseInt(age.getText().toString());
                updateStudent(newName, newAge, studentId);
            }
        });

        inputDialog.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        inputDialog.show();
    }

    public void createDatabaseSchema(){
        database=openOrCreateDatabase("STUDENT_DB",MODE_PRIVATE, null);
        String query="CREATE TABLE IF NOT EXISTS STUDENTS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AGE INTEGER)";
        database.execSQL(query);

        //Now check if table is created i.e Does it exist?
        String checkQuery="SELECT DISTINCT tbl_name FROM sqlite_master WHERE tbl_name='STUDENTS'";
        Cursor cursor=database.rawQuery(checkQuery,null);

        if(cursor!=null){
            if(cursor.getCount()>0){
                cursor.close();
                Toast.makeText(this, "DB with STUDENTS table created successfully", Toast.LENGTH_SHORT).show();
                return;
            }
            else{
                cursor.close();
                Toast.makeText(this, "Query FAILED", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public Boolean addStudent(String name, int age){

        ContentValues contents=new ContentValues();
        contents.put("NAME",name);
        contents.put("AGE",age);
        int resp=(int)database.insert("STUDENTS",null,contents);
        return resp>0?true:false;
    }

    public void deleteAllStudents(){
        String query="DELETE FROM STUDENTS";
        database.execSQL(query);
        int totalRecords=getTotalRecords();

        if(totalRecords<=1){
            Toast.makeText(this, "DELETED", Toast.LENGTH_SHORT).show();
            students.clear();
            adapter.notifyDataSetChanged();
        }
        else{
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
        }
    }

    public void getAllStudents(){
        students.clear();
        String query="SELECT * FROM STUDENTS";
        Cursor cursor=database.rawQuery(query,null);
        cursor.moveToFirst();
        if(cursor.getCount()>0){
            do{
                String record=cursor.getInt(0)+"      "+cursor.getString(1)+"        "+cursor.getInt(2);
                students.add(record);
            }while (cursor.moveToNext());
        }
        cursor.close();
        adapter.notifyDataSetChanged();
    }
    public int getIdForNewRecord(){
        String query="SELECT ID FROM STUDENTS ORDER BY ID DESC LIMIT 1";
        Cursor c=database.rawQuery(query,null);
        c.moveToFirst();
        int id=c.getInt(0);
        c.close();
        return id;
    }
    public int getTotalRecords(){
        String query="SELECT COUNT(*) FROM STUDENTS";
        Cursor c=database.rawQuery(query,null);
        c.moveToFirst();
        int total=c.getInt(0);
        c.close();
        return total;
    }

    public void updateStudent(String newName, int newAge, int id){
        String query="UPDATE STUDENTS SET NAME='"+newName+"', AGE='"+newAge+"' WHERE ID='"+id+"'";
        database.execSQL(query);
        getAllStudents();
    }
}