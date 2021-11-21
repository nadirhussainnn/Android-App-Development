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
        graphView=findViewById(R.id.dataGraph);
        graphView.setTitle("Users");

        // set X bounds; Y is the same idea
        graphView.getViewport().setXAxisBoundsManual(true);
        graphView.getViewport().setMinX(10);
        graphView.getViewport().setMaxX(65);

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        DataPoint point1 = new DataPoint(25, 125);
        DataPoint point2 = new DataPoint(25, 125);
        DataPoint point3 = new DataPoint(25, 125);
        DataPoint point4 = new DataPoint(25, 125);
        DataPoint point5 = new DataPoint(25, 125);

        series.appendData(point1, false, 10);
        series.appendData(point2, false, 10);
        series.appendData(point3, false, 10);
        series.appendData(point4, false, 10);
        series.appendData(point5, false, 10);


        graphView.addSeries(series);
    }
}