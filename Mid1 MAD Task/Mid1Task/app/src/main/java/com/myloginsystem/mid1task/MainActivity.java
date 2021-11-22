package com.myloginsystem.mid1task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName, userPass;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=findViewById(R.id.userName);
        userPass=findViewById(R.id.userPassword);

        preferences=getSharedPreferences("users",MODE_PRIVATE);
        editor=preferences.edit();


        String name=preferences.getString("username", "");
        String pass=preferences.getString("userpass","");

        if(name.equalsIgnoreCase("") || pass.equalsIgnoreCase("")){
            Toast.makeText(this, "User not registered", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            userName.setText(name);
            userPass.setText(pass);
        }
//        Intent intent=new Intent(this,GameActivity.class);
//        startActivity(intent);
//        finish();


    }
    public void loginUser(View v){

        String name=preferences.getString("username", "");
        String pass=preferences.getString("userpass","");

        if(name.equalsIgnoreCase(userName.getText().toString()) && pass.equalsIgnoreCase(userPass.getText().toString())){
            Intent intent=new Intent(this,GameActivity.class);
            startActivity(intent);
            finish();
        }
        else
        Toast.makeText(this, "User not registered", Toast.LENGTH_SHORT).show();

    }

    public void registerUser(View v){

        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}