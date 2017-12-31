package com.example.rhshukla.grid;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public void playMusic1(View v)
    {

        MediaPlayer m1=MediaPlayer.create(this,R.raw.one);
        m1.start();
    }


    public void playMusic2(View v)
    {

        MediaPlayer m2=MediaPlayer.create(this,R.raw.two);
        m2.start();
    }

    public void playMusic3(View v)
    {

        MediaPlayer m3=MediaPlayer.create(this,R.raw.three);
        m3.start();
    }

    public void playMusic4(View v)
    {

        MediaPlayer m4=MediaPlayer.create(this,R.raw.four);
        m4.start();
    }

    public void playMusic5(View v)
    {

        MediaPlayer m5=MediaPlayer.create(this,R.raw.five);
        m5.start();
    }

    public void playMusic6(View v)
    {

        MediaPlayer m6=MediaPlayer.create(this,R.raw.six);
        m6.start();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
