package com.myloginsystem.frg;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class First extends Fragment {

    MainActivity context;
    public First(MainActivity mainActivity) {
        this.context=mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_first, container, false);
        TextView text=v.findViewById(R.id.val);
        String st=text.getText().toString();
        return  v;

    }
}