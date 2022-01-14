package com.myloginsystem.tts_stt;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech tts;

    EditText text;
    Boolean isReady=false;
    int counter=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.input);

        Handler handler=new Handler();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {

                while (true){

                    try {
                        counter++;

                        text.post(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(""+counter);
                            }
                        });

                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                text.setText(""+counter);
                            }
                        });


//                        runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                text.setText(""+counter);
//                            }
//                        });
                        Thread.sleep(1000);
                    }catch (Exception ex){}
                }

            }
        });

        thread.start();

        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                     isReady=true;
            }
        });
    }

    public void speak(View view) {

        if(isReady){
            tts.speak(text.getText().toString(), TextToSpeech.QUEUE_ADD,null);
        }
    }

    public void listen(View view) {

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Galhae Kujh bha");
        startActivityForResult(intent, 1234);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1234){
            ArrayList<String> result=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
            String words=result.get(0);
            text.setText(words);
        }
    }
}