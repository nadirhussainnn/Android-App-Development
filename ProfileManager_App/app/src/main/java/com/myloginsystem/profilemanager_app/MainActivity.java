package com.myloginsystem.profilemanager_app;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    EditText name,email,pass;
    ImageView profileImage;
    final int APP_CODE=1234;
    Uri captured_image=null;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    String encoded="";

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
        editor.putString("image",encoded);
        editor.commit();

    }
    public void displayProfiles(View v){
        Intent intent=new Intent(this, DisplayProfilesActivity.class);
        startActivity(intent);
    }

    public void clearProfiles(){

        editor.clear();
        editor.commit();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==APP_CODE){
            if(resultCode==RESULT_OK){

                //                captured_image=data.getData(); : DOES NOT WORKS

                Bitmap photo = (Bitmap) data.getExtras().get("data");
                profileImage.setImageBitmap(photo);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                photo.compress(Bitmap.CompressFormat.PNG, 100, baos);
                byte[] b = baos.toByteArray();
                encoded = Base64.encodeToString(b, Base64.DEFAULT);
            }
        }
    }
}

//https://www.geeksforgeeks.org/how-to-share-a-captured-image-to-another-app-in-android/