package com.example.ahoj;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class List extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        int i, imax;
        String x, y, t;

        calculations.local();
        imax = calculations.xcoords.size();
        System.out.println("imax:"+imax); //vypis.. vymazat
        String[] list = new String[imax];

        for(i = 0; i < imax; i += 1) {
            x = String.valueOf(calculations.xcoords.get(i));
            y = String.valueOf(calculations.ycoords.get(i));
            t = String.valueOf(calculations.tcoords.get(i));
            list[i] = "time:" + t + "    " + "X:" + x + "   " + "Y:" + y;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_listview, list);
        ListView listView = (ListView)findViewById(R.id.listview);
        System.out.println(listView);
        listView.setAdapter(adapter);
    }
}