package com.example.ahoj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class GraphActivity extends AppCompatActivity {

    GraphView graphView;
    int i;
    static int iMax = calculations.xcoords.size();
    static DataPoint[] position = new DataPoint[iMax];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph);

        Double x, y;
        graphView = findViewById(R.id.idGraphView);

        calculations.local();

        for (i = 0; i < iMax; i += 1){
            x = calculations.xcoords.get(i);
            y = calculations.ycoords.get(i);

            position[i] = new DataPoint(x, y);
        }

        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(position);

        graphView.setTitle("Motion Graph");

        graphView.setTitleColor(R.color.red);
        graphView.setTitleTextSize(50);
        graphView.addSeries(series);
    }

    public static double getPositionX(int index) {
        return (float) position[index].getX();
    }

    public static double getPositionY(int index) {
        return (float) position[index].getY();
    }
}