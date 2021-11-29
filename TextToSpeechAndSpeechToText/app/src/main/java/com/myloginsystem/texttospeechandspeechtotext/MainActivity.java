package com.myloginsystem.texttospeechandspeechtotext;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.Voice;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class MainActivity extends AppCompatActivity {


    TextToSpeech tts;
    EditText text;
    Boolean isReady=false;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=findViewById(R.id.textInput);
        textView=findViewById(R.id.textHolder);
        textView.setVisibility(View.INVISIBLE);

        tts=new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                isReady=true;
            }
        });
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void clickMe(View v){
        if(isReady){

            Set<String> a=new HashSet<>();
            a.add("male");//here you can give male if you want to select mail voice.

            Voice va=new Voice("en-us-x-smg#male_2-local",new Locale("en","US"),400,200,true,a);
            tts.setVoice(va);

        tts.speak(text.getText().toString(),TextToSpeech.QUEUE_ADD, null,null);
            //Modes: Define what type of action speaker will take
            //Add previous sentence to new: QUEUE_ADD
            //Just say the latest sentence, remove previous: QUEUE_FLUSH
        }
    }

    public void speechToText(View v){

        Intent intent=new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        //We fetched default language from our mobile device in string
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Galhae putr");

        try{
            startActivityForResult(intent,1234);
        }catch (Exception ex){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1234){
            ArrayList<String> list=data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            String spokenText=list.get(0);  //identified text is on 0th index
            textView.setText(spokenText);
            textView.setVisibility(View.VISIBLE);
        }
    }
}