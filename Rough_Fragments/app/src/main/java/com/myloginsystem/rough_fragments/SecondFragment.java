package com.myloginsystem.rough_fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {


    TextView counterText;
    int counter;
    MainActivity context;
    public SecondFragment(MainActivity context){
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_second, container, false);
        counterText=v.findViewById(R.id.counterView2);
        counterText.setText("Value is "+context.getCounter());
        return v;
    }
}