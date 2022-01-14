package com.myloginsystem.primacy_recency_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText userName, password;
    Intent registerIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppAnimations animations=new AppAnimations(this);
        animations.setAnimation();

        setContentView(R.layout.activity_register);
        userName=findViewById(R.id.usernameField);
        password=findViewById(R.id.passwordField);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void registerToApp(View view) {

        String name=userName.getText().toString();
        String pass=password.getText().toString();

        if(name.length()>0 && pass.length()>0){

            registerIntent=new Intent(this, UserActivity.class);

            if(Build.VERSION.SDK_INT>20)
            {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(registerIntent,options.toBundle());
            }
            else {
                startActivity(registerIntent);
            }


//            overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
        }
    }

    public void gotoLoginScreen(View view) {
        Intent intent=new Intent(this, LoginActivity.class);

        if(Build.VERSION.SDK_INT>20)
        {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            startActivity(intent,options.toBundle());
        }
        else {
            startActivity(intent);
        }

        finish();
//        overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
    }
}