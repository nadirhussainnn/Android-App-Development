package com.myloginsystem.primacy_recency_effect;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText userName, password;
    Intent registerIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppAnimations animations=new AppAnimations(this);
        animations.setAnimation();

        setContentView(R.layout.activity_login);

        userName=findViewById(R.id.usernameField);
        password=findViewById(R.id.passwordField);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }

    public void loginToApp(View view) {

        String name=userName.getText().toString();
        String pass=password.getText().toString();

        if(name.length()>0 && pass.length()>0){

            Intent userActivityIntent=new Intent(this, UserActivity.class);
            startActivity(userActivityIntent);

        }
    }

    public void gotoRegisterScreen(View v){

        registerIntent=new Intent(this, RegisterActivity.class);

        if(Build.VERSION.SDK_INT>20)
        {
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
            startActivity(registerIntent,options.toBundle());
        }
        else {
            startActivity(registerIntent);
        }
    }
}