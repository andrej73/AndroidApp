package com.example.ahoj;

import static java.lang.Math.round;

import java.util.ArrayList;

public class calculations {

    public static ArrayList<Double>xcoords;
    public static ArrayList<Double>ycoords;
    public static ArrayList<Double>tcoords;
    public static double g = 10, timestep = 0.1, speed, angle;

    private static void init() {
        if(xcoords == null || ycoords == null || tcoords == null){
            xcoords = new ArrayList<>();
            ycoords = new ArrayList<>();
            tcoords = new ArrayList<>();
        }
    }

    public static void local() {
        double x = 0, y = 0, t = 0;
        double timestop = (2*speed*Math.sin(Math.toRadians(angle))) / g;
        init();

        for(;t< timestop; t += timestep){
            x = speed * t * Math.cos(Math.toRadians(angle));
            y = speed * t * Math.sin(Math.toRadians(angle)) - (g * Math.pow(t,2)) / 2;
            xcoords.add((double) round(x * 100.0 / 100.0));
            ycoords.add((double) round(y * 100.0 / 100.0));
            tcoords.add((double) round(t * 100.0 / 100.0));
        }
        x = speed * timestop * Math.cos(Math.toRadians(angle));
        xcoords.add((double) round(x * 100.0 / 100.0));
        ycoords.add(0.0);
        tcoords.add((double) round(t * 100.0 / 100.0));
    }
}
