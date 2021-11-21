package com.myloginsystem.profilemanager_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    EditText name,email,pass;
    ImageView profileImage;
    final int APP_CODE=1234;
    Uri captured_image=null;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        pass=findViewById(R.id.password);
        profileImage=findViewById(R.id.profileImage);
        preferences=getSharedPreferences("activityData",MODE_PRIVATE);
        editor=preferences.edit();

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,APP_CODE);
            }
        });
    }


    public void storeProfile(View v){

        editor.putString("name",name.getText().toString());
        editor.putString("email",email.getText().toString());
        editor.putString("pass",pass.getText().toString());
        editor.putString("image",String.valueOf(captured_image));
        editor.commit();
    }
    public void displayProfiles(View v){
        Intent intent=new Intent(this, DisplayProfilesActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode!=APP_CODE){
            if(resultCode==RESULT_OK){
                captured_image=data.getData();
            }
        }
    }
}

//https://www.geeksforgeeks.org/how-to-share-a-captured-image-to-another-app-in-android/