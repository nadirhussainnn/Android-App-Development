package com.myloginsystem.fragments_starter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Fragment1 extends Fragment {


    Button btn;
    TextView textView;
    Boolean clicked=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v=inflater.inflate(R.layout.fragment_1,container, false);
        btn=v.findViewById(R.id.fragment1_btn);
        textView=v.findViewById(R.id.msgText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s=clicked?"Ok":"Cancel";
                clicked=!clicked;
                textView.setText(s);
            }
        });

        return v;
    }
}