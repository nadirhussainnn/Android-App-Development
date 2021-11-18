package com.myloginsystem.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {

    String []entries=new String[]{"Nadir Hussain","Noman Aijaz","Hans Raj","Nadir Hussain","Noman Aijaz","Hans Raj","Nadir Hussain","Noman Aijaz","Hans Raj","Nadir Hussain","Noman Aijaz","Hans Raj","Nadir Hussain","Noman Aijaz","Hans Raj","Nadir Hussain","Noman Aijaz","Hans Raj","Nadir Hussain","Noman Aijaz","Hans Raj"};

    ArrayAdapter<String> adapter=null;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView=findViewById(R.id.listView);
        adapter=new ArrayAdapter<String>(this,R.layout.item,entries);
        listView.setAdapter(adapter);
    }
}