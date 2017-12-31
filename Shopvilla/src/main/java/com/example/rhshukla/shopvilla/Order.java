package com.example.rhshukla.shopvilla;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Order extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    GridView androidGridView;

    String[] gridViewString = {
             "t-shirt", "photo", "Watch",
             "lighte", "file", "Press",
             "lite", "file", "Press",

    } ;
    int[] gridViewImageId = {
            R.drawable.spl, R.drawable.spl, R.drawable.spl,
            R.drawable.spl, R.drawable.spl, R.drawable.spl,
            R.drawable.spl, R.drawable.spl, R.drawable.spl,

    };
    String[] gridpriceString = {
            " Rs.250", "Rs.250", "Rs.250",
            "Rs.250", "Rs.250", "Rs.250",
            "Rs.250", "Rs.250", "Rs.250",

    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_order );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );

        CustomGridViewActivity adapterViewAndroid = new CustomGridViewActivity(Order.this, gridViewString, gridViewImageId,gridpriceString);
        androidGridView=(GridView)findViewById(R.id.grid_view_image_text);
        androidGridView.setAdapter(adapterViewAndroid);
        androidGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int i, long id) {
                Toast.makeText(Order.this, "GridView Item: " + gridViewString[+i], Toast.LENGTH_LONG).show();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Mian=new Intent( Order.this,MainActivity.class );
                startActivity( Mian );
            }
        } );

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
        drawer.addDrawerListener( toggle );
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate( R.menu.order, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected( item );
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_login)
        {
            Intent login=new Intent(Order.this,Login.class);
            startActivity(login );
            finish();

            // Handle the camera action
        }
        else if (id == R.id.nav_home)
        {
            Intent login=new Intent(Order.this,Address.class);
            startActivity(login );
            finish();
        }
        else if (id == R.id.nav_order)
        {
            Intent login=new Intent(Order.this,Order.class);
            startActivity(login );
            finish();
        }

        else if (id == R.id.nav_cart) {
            Intent login = new Intent( Order.this, yourcart.class );
            startActivity( login );
            finish();
        }

        else if (id == R.id.nav_offers)

        {
            Intent login=new Intent(Order.this,offers.class);
            startActivity(login );
            finish();
        }
        else if (id == R.id.nav_help) {

        }
        else if (id == R.id.nav_share)
        {
            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType("text/plain");
            String shareBody = "download this amazing app;";
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Important");
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(sharingIntent, "Share via"));
        }
        else if (id == R.id.nav_rate) {
            Intent login=new Intent(Order.this,Rateus.class);
            startActivity(login );
            finish();

        }
        else if(id == R.id.nav_about)
        {
            Intent login=new Intent(Order.this,aboutus.class);
            startActivity(login );
            finish();

        }
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }
}
