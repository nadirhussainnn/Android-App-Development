package com.myloginsystem.mid2_practice;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MediaPlayerActivity extends AppCompatActivity {

    Button playBtn, pauseBtn, stopBtn,loopBtn;
    public static MediaPlayer player;
    public static Boolean isPlaying=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        playBtn=findViewById(R.id.playBtn);
        pauseBtn=findViewById(R.id.pauseBtn);
        stopBtn=findViewById(R.id.stopBtn);
        loopBtn=findViewById(R.id.loopBtn);

        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!isPlaying){
                    isPlaying=true;
                    player=MediaPlayer.create(getApplicationContext(),R.raw.audio1);
                    player.start();
                }
                else{
                    Toast.makeText(MediaPlayerActivity.this, "Already Playing", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Listener listener=new Listener(this);

        pauseBtn.setOnClickListener(listener);
        stopBtn.setOnClickListener(listener);
        loopBtn.setOnClickListener(listener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();

        switch (id){
            case R.id.optionMenuItem1:

                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();
                break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}

class Listener extends MediaPlayerActivity implements View.OnClickListener{

    MediaPlayerActivity context;
    int position=0;
    public static Boolean isPause=false;
    public Listener(MediaPlayerActivity context){
        this.context=context;
    }
    @Override
    public void onClick(View v) {

        int id=v.getId();

        switch (id){
            case R.id.pauseBtn:
                if(isPlaying){
                    player.pause();
                    isPlaying=false;
                    isPause=true;
                    position=player.getCurrentPosition();
                    ((Button)v).setText("Resume");
                }
                else{
                    if(isPause) {
                        ((Button) v).setText("Pause");
                        player.seekTo(position);
                        player.start();
                        isPlaying=true;
                        isPause=false;
                    }

                }
                break;
            case R.id.stopBtn:
                if(isPlaying){
                    player.stop();
                    isPlaying=false;
                }
                break;

            case R.id.loopBtn:
                if(isPlaying){
                    player.setLooping(true);
                }
                break;
            default:
            break;
        }
    }
}