package com.myloginsystem.profilemanager_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayProfilesActivity extends AppCompatActivity {

    String name, pass, email;
    Uri image;

    TextView userName, userEmail, userPass;
    ImageView userProfileImage;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_profiles);

        userName=findViewById(R.id.nameDisplay);
        userEmail=findViewById(R.id.emailDisplay);
        userPass=findViewById(R.id.passwordDisplay);
        userProfileImage=findViewById(R.id.profileImageDisplay);

        preferences=getSharedPreferences("activityData",MODE_PRIVATE);

        name=preferences.getString("name","No Name");
        email=preferences.getString("email","No Email");
        pass=preferences.getString("pass","No pass");

        userName.setText(name);
        userEmail.setText(email);
        userPass.setText(pass);
        byte[] imageAsBytes = Base64.decode(preferences.getString("image","No Image").getBytes(), Base64.DEFAULT);
        userProfileImage.setImageBitmap(BitmapFactory.decodeByteArray(imageAsBytes, 0, imageAsBytes.length));

    }

    public void gotoHome(View v){
        finish();
    }
}