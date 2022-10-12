package com.example.ahoj;

import static java.lang.Double.parseDouble;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btn, btn2, btnAnim;
    EditText ETspeed, ETangle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btnAnim = (Button) findViewById(R.id.buttonAnimation);
        ETspeed = (EditText) findViewById(R.id.speed);
        ETangle = (EditText) findViewById(R.id.angle);
        btnAnim.setOnClickListener((v) -> {
            Intent i = new Intent(MainActivity.this, AnimationActivity.class);
            startActivity(i);
        });
    }

    public void onClickListener(View v) {
        String string = ETspeed.getText().toString();
        calculations.speed = parseDouble(string);
        string = ETangle.getText().toString();
        calculations.angle = parseDouble(string);
        Intent i = new Intent(MainActivity.this, List.class);
        startActivity(i);
    }

    public void onClickGraph(View v) {
        Intent i = new Intent(MainActivity.this, GraphActivity.class);
        startActivity(i);
    }
}