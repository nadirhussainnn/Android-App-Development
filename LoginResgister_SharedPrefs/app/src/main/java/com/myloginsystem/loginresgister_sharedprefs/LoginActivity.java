package com.myloginsystem.loginresgister_sharedprefs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences=getSharedPreferences("users", MODE_PRIVATE);
        editor=preferences.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        Intent intent;
        switch (id){
            case R.id.login:
                intent=new Intent(this,LoginActivity.class);
                startActivity(intent);
                break;

            case R.id.register:
                intent=new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }

    public void gotoDashboard(View v){

        String userName=preferences.getString("username","null");
        String userPassword=preferences.getString("password","null");

        if(userName.equalsIgnoreCase("null") || userPassword.equalsIgnoreCase("null")){
            Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent=new Intent(this,DashboardActivity.class);
        startActivity(intent);
        finish();
    }
    public void register(View v){
        Intent intent=new Intent(this,RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}