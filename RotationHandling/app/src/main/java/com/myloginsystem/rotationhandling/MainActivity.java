package com.myloginsystem.rotationhandling;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String firstName;
    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=findViewById(R.id.firstName);
        firstName=name.getText().toString();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("tag",firstName+" First Name onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("tag",firstName+" First Name onResume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("tag",firstName+" First Name onDestroy");
    }
}