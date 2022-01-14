package com.myloginsystem.primacy_recency_effect;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;

import com.google.android.material.appbar.MaterialToolbar;

public class UserActivity extends AppCompatActivity {

    MaterialToolbar appbar;
    DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppAnimations animations=new AppAnimations(this);
        animations.setAnimation();

        setContentView(R.layout.activity_user);
        appbar=findViewById(R.id.topAppBar);
        drawer=findViewById(R.id.drawer);

        appbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer.open();
            }
        });
    }
}