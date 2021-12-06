package com.example.themes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TopRoundedFragment extends Fragment {


    public TopRoundedFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_top_rounded, container, false);
        String[] foodItems = new String[]{"Burger", "Fries", "Pizza", "ColdDrinks"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(v.getContext(),R.layout.food_item,foodItems);
        ListView listView= v.findViewById(R.id.Foodlist);
        listView.setAdapter(adapter);
        return v;
    }
}