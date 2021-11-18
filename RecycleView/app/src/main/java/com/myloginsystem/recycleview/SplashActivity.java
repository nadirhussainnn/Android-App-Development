package com.myloginsystem.recycleview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    Animation top, bottom;
    ImageView logo;
    TextView slogan;
    private int SPLASH_SCREEN_DURATION=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        logo=findViewById(R.id.logo);
        slogan=findViewById(R.id.slogan);

        top= AnimationUtils.loadAnimation(this,R.anim.top_anim);
        bottom= AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        logo.setAnimation(top);
        slogan.setAnimation(bottom);
        
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN_DURATION);
    }
}