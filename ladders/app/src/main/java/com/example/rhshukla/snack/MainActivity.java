package com.example.rhshukla.snack;

import android.support.v4.util.LogWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int [] dice={
            R.drawable.one,
            R.drawable.two,
            R.drawable.three,
            R.drawable.four,
            R.drawable.five,
            R.drawable.six,

    };

    public void Roll(View v)
    {

        Random rn=new Random();

        int ch=rn.nextInt(6);

        ImageView sel=(ImageView) findViewById(R.id.dice);

        sel.setImageResource(dice[ch]);
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
