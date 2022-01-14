package com.myloginsystem.namesurfer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    GraphView graphView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        graphView=findViewById(R.id.dataGraph);
//        graphView.setTitle("Users");
//
//        // set X bounds; Y is the same idea
//        graphView.getViewport().setXAxisBoundsManual(true);
//        graphView.getViewport().setMinX(10);
//        graphView.getViewport().setMaxX(65);
//
//        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
//                new DataPoint(0, 1),
//                new DataPoint(1, 5),
//                new DataPoint(2, 3),
//                new DataPoint(3, 2),
//                new DataPoint(4, 6)
//        });
//        graphView.addSeries(series);
    }
}