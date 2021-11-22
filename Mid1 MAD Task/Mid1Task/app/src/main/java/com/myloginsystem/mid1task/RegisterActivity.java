package com.myloginsystem.mid1task;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText userName, userPass;
   SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userName=findViewById(R.id.userNameRegister);
        userPass=findViewById(R.id.userPasswordRegister);

        preferences=getSharedPreferences("users",MODE_PRIVATE);
        editor=preferences.edit();

    }

    public void registerUser(View v){

        String name=userName.getText().toString();
        String pass=userPass.getText().toString();

        if(name.length()>0 && pass.length()>0){
            editor.putString("username",name);
            editor.putString("userpass",pass);
            editor.commit();

            Intent intent=new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            Toast.makeText(this, "Invalid name or password", Toast.LENGTH_SHORT).show();
        }
    }
    public void loginUser(View v){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}