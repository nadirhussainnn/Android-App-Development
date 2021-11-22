package com.myloginsystem.mid1task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ImageView dice1, dice2;
    TextView dice1Text, dice2Text;
    Button rollBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        rollBtn=findViewById(R.id.rollBtn);

        rollBtn.setEnabled(true);
        dice1=findViewById(R.id.dice1);
        dice2=findViewById(R.id.dice2);
        dice1Text=findViewById(R.id.dice1Text);
        dice2Text=findViewById(R.id.dice2Text);

        preferences=getSharedPreferences("users",MODE_PRIVATE);
        editor=preferences.edit();




    }

    public void rollDices(View v){

        Random random1=new Random();
        Random random2=new Random();

        int randomNumber1=random1.nextInt(6);
        int randomNumber2=random2.nextInt(6);

        randomNumber1+=1;
        randomNumber2+=1;

        if(randomNumber1==1){
            dice1.setImageResource(R.drawable.a1);
        }
        else if(randomNumber1==2){
            dice1.setImageResource(R.drawable.a2);
        }
        else if(randomNumber1==3){
            dice1.setImageResource(R.drawable.a3);
        }
        else if(randomNumber1==4){
            dice1.setImageResource(R.drawable.a4);
        }
        else if(randomNumber1==5){
            dice1.setImageResource(R.drawable.a5);
        }
        else if(randomNumber1==6){
            dice1.setImageResource(R.drawable.a6);
        }

        if(randomNumber2==1){
            dice2.setImageResource(R.drawable.a1);
        }
        else if(randomNumber2==2){
            dice2.setImageResource(R.drawable.a2);
        }
        else if(randomNumber2==3){
            dice2.setImageResource(R.drawable.a3);
        }
        else if(randomNumber2==4){
            dice2.setImageResource(R.drawable.a4);
        }
        else if(randomNumber2==5){
            dice2.setImageResource(R.drawable.a5);
        }
        else if(randomNumber2==6){
            dice2.setImageResource(R.drawable.a6);
        }

        dice1Text.setText(randomNumber1+"");
        dice2Text.setText(randomNumber2+"");
        checkWin(randomNumber1, randomNumber2);
    }

    public void checkWin(int dice1Number, int dice2Number){
        if(dice1Number==dice2Number){
            Toast.makeText(this, "User Won", Toast.LENGTH_SHORT).show();
            rollBtn.setEnabled(false);
            return;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.game_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id=item.getItemId();
        switch (id){
            case R.id.logoutItem:
                Intent intent=new Intent(this,MainActivity.class);
                editor.clear();
                editor.commit();
                startActivity(intent);
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}


/*


        String name1=getResources().getResourceEntryName(R.drawable.a1);
        int img1=Integer.parseInt(name1.trim().substring(1,name1.length()));

        String name2=getResources().getResourceEntryName(R.drawable.a2);
        int img2=Integer.parseInt(name2.trim().substring(1,name2.length()));

        String name3=getResources().getResourceEntryName(R.drawable.a3);
        int img3=Integer.parseInt(name3.trim().substring(1,name3.length()));

        String name4=getResources().getResourceEntryName(R.drawable.a4);
        int img4=Integer.parseInt(name4.trim().substring(1,name4.length()));

        String name5=getResources().getResourceEntryName(R.drawable.a5);
        int img5=Integer.parseInt(name5.trim().substring(1,name5.length()));

        String name6=getResources().getResourceEntryName(R.drawable.a6);
        int img6=Integer.parseInt(name6.trim().substring(1,name6.length()));

        if(img1==randomNumber1){
            dice1.setImageResource(R.drawable.a1);
        }
        else if(img2==randomNumber1){
            dice1.setImageResource(R.drawable.a2);
        }
        else if(img3==randomNumber1){
            dice1.setImageResource(R.drawable.a3);
        }
        else if(img4==randomNumber1){
            dice1.setImageResource(R.drawable.a4);
        }
        else if(img5==randomNumber1){
            dice1.setImageResource(R.drawable.a5);
        }
        else if(img6==randomNumber1){
            dice1.setImageResource(R.drawable.a6);
        }


        if(img1==randomNumber1){
            dice1.setImageResource(R.drawable.a1);
        }
        else if(img2==randomNumber1){
            dice1.setImageResource(R.drawable.a2);
        }
        else if(img3==randomNumber1){
            dice1.setImageResource(R.drawable.a3);
        }
        else if(img4==randomNumber1){
            dice1.setImageResource(R.drawable.a4);
        }
        else if(img5==randomNumber1){
            dice1.setImageResource(R.drawable.a5);
        }
        else if(img6==randomNumber1){
            dice1.setImageResource(R.drawable.a6);
        }

 */