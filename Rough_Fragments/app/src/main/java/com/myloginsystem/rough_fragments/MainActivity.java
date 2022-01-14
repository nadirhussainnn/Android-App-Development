package com.myloginsystem.rough_fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {


    FrameLayout container;
    FirstFragment fragment1;
    SecondFragment fragment2;
    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container=findViewById(R.id.fragmentContainer);

        fragment1=new FirstFragment(this);
        fragment2=new SecondFragment(this);

        FragmentManager manager=getSupportFragmentManager();

        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(container.getId(),fragment1);
        transaction.commit();

    }

    public void launchFragment1(View view) {

        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(container.getId(),fragment1);
        transaction.commit();
    }

    public void launchFragment2(View view) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.replace(container.getId(),fragment2);
        transaction.commit();
    }

    public void setCounter(int counter){
        this.counter=counter;
    }

    public int getCounter(){
        return this.counter;
    }
}