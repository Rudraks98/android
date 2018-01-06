package com.example.rhshukla.port1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.rhshukla.port1.Controler.davPagerAdepter;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        viewpager=findViewById( R.id.viewpager );
        viewpager.setAdapter(new davPagerAdepter( getSupportFragmentManager() ) );

        TabLayout tb=findViewById( R.id.tablay );
        tb.setupWithViewPager( viewpager );

        TextView git=findViewById( R.id.GetInTouch );

        git.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+918238209374"));
                startActivity(intent);
            }
        });
    }
}
