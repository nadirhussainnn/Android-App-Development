package com.myloginsystem.loginresgister_sharedprefs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    EditText userName, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        userName=findViewById(R.id.userNameRegister);
        pass=findViewById(R.id.passwordRegister);

        preferences=getSharedPreferences("users",MODE_PRIVATE);
        editor=preferences.edit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
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

    public void login(View v){
        Intent intent=new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    public void register(View v){

        String name=userName.getText().toString();
        String password=pass.getText().toString();
        editor.putString("username", name);
        editor.putString("password", password);
        editor.commit();

        Intent intent=new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }
}