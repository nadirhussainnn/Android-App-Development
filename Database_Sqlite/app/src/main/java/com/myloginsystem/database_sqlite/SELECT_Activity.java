package com.myloginsystem.database_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SELECT_Activity extends AppCompatActivity {

    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_e_l_e_c_t_);

        Intent intent=getIntent();
        String records=intent.getStringExtra("records");
        text=findViewById(R.id.records);
        text.setText(records);
    }

    public void goBack(View v){
        finish();
    }
}