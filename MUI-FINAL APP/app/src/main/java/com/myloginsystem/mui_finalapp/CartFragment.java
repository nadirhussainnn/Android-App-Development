package com.myloginsystem.mui_finalapp;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.transition.MaterialContainerTransform;
import com.google.android.material.transition.MaterialFadeThrough;
import com.google.android.material.transition.MaterialSharedAxis;

public class CartFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        MaterialFadeThrough materialFadeThrough  = new MaterialFadeThrough();
//        setEnterTransition(materialFadeThrough);

        @SuppressLint("WrongConstant")
        MaterialSharedAxis materialSharedAxis_exit  = new MaterialSharedAxis(2,true);
        materialSharedAxis_exit.setDuration(2000);
        setExitTransition(materialSharedAxis_exit);

        @SuppressLint("WrongConstant")
        MaterialSharedAxis materialSharedAxis_return = new MaterialSharedAxis(0,false);
        materialSharedAxis_exit.setDuration(2000);
        setReturnTransition(materialSharedAxis_return);

//
//        @SuppressLint("WrongConstant")
//        MaterialSharedAxis materialSharedAxis_re_enter  = new MaterialSharedAxis(2,false);
//        materialSharedAxis_exit.setDuration(1000);
//        setReenterTransition(materialSharedAxis_re_enter);

//        MaterialContainerTransform materialContainerTransform = new MaterialContainerTransform();
//        materialContainerTransform.setDuration(3000);
////        materialContainerTransform.setFadeMode(MaterialContainerTransform.FADE_MODE_OUT);
//        setSharedElementEnterTransition(materialContainerTransform);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false);
    }
}