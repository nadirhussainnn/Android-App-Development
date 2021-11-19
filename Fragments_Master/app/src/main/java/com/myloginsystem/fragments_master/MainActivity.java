package com.myloginsystem.fragments_master;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void openFragment(View v){

        int id=v.getId();

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();

        switch (id){
            case R.id.fragment1Btn:
                FirstFragment fragment1=new FirstFragment();
                transaction.replace(R.id.contentArea, fragment1);
                transaction.commit();
                break;
            case R.id.fragment3Btn:
                ThirdFragment fragment3=new ThirdFragment();
                transaction.replace(R.id.contentArea, fragment3);
                transaction.commit();
                break;
            default:
        }
    }
}