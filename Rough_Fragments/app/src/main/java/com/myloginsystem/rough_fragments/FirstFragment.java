package com.myloginsystem.rough_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class FirstFragment extends Fragment {

    private int counter=0;

    MainActivity context;
    FirstFragment(MainActivity context){
     this.context=context;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_first, container, false);

        TextView counterText=v.findViewById(R.id.counter);
        Button b=v.findViewById(R.id.increase);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;

                counterText.setText("Value is: "+counter);
                context.setCounter(counter);
            }
        });
        return v;
    }
}