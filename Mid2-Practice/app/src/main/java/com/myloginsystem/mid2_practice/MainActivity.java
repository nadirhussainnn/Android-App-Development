package com.myloginsystem.mid2_practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchMediaPlayerActivity(View view) {
        intent=new Intent(this, MediaPlayerActivity.class);
        startActivity(intent);
    }

    public void launchOptionMenuActivity(View view) {
        intent=new Intent(this, OptionsMenuActivity.class);
        startActivity(intent);
    }

    public void launchFloatingContextMenuActivity(View view) {
        intent=new Intent(this, FloatingContextMenu.class);
        startActivity(intent);

    }

    public void launchContextualActionModeActivity(View view) {
        intent=new Intent(this, ContextualActionModeActivity.class);
        startActivity(intent);

    }

    public void launchDatabaseActivity(View view) {
        
    }
}