package com.myloginsystem.mui_finalapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.transition.MaterialSharedAxis;

public class DashboardFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        @SuppressLint("WrongConstant")

        MaterialSharedAxis materialSharedAxis_exit  = new MaterialSharedAxis(2,true);
        materialSharedAxis_exit.setDuration(1000);
        setExitTransition(materialSharedAxis_exit);

        @SuppressLint("WrongConstant")
        MaterialSharedAxis materialSharedAxis_re_enter  = new MaterialSharedAxis(2,false);
        materialSharedAxis_re_enter.setDuration(1000);
        setReenterTransition(materialSharedAxis_re_enter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }
}