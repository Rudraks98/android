    package com.example.rhshukla.shopvilla;

    import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.Calendar;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

    public class aboutus extends AppCompatActivity
            implements NavigationView.OnNavigationItemSelectedListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate( savedInstanceState );
            setContentView( R.layout.activity_aboutus );
            Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
            setSupportActionBar( toolbar );

            FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
            fab.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                }
            } );

            DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close );
            drawer.addDrawerListener( toggle );
            toggle.syncState();

            NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
            navigationView.setNavigationItemSelectedListener( this );
            Intent Main=new Intent( aboutus.this,MainActivity.class );

            simulateDayNight(/* DAY */ 0);
            Element adsElement = new Element();
            adsElement.setTitle("Advertise with us");

            Element backElement = new Element();
            backElement.setTitle("Back to the app");
            backElement.setIntent( Main );
            backElement.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent Main=new Intent( aboutus.this,MainActivity.class );
                    startActivity( Main  );

                }
            });



            View aboutPage = new AboutPage(this)
                    .isRTL(false)
                    .setImage(R.drawable.spl)
                    .addItem(new Element().setTitle("Version 1.0."))
                    .addItem(adsElement)
                    .addGroup("Connect with us")
                    .addEmail("elmehdi.sakout@gmail.com")
                    .addWebsite("http://medyo.github.io/")
                    .addFacebook("the.medy")
                    .addTwitter("medyo80")
                    .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                    .addPlayStore("com.ideashower.readitlater.pro")
                    .addInstagram("medyo80")
                    .addGitHub("medyo")
                    .addItem(getCopyRightsElement())
                    .addItem( backElement )
                    .create();

            setContentView(aboutPage);

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
            getMenuInflater().inflate( R.menu.aboutus, menu );
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
            // Handle navigation view item clicks here.
            int id = item.getItemId();

            if (id == R.id.nav_login)
            {
                Intent login=new Intent(aboutus.this,Login.class);
                startActivity(login );
                finish();

                // Handle the camera action
            }
            else if (id == R.id.nav_home)
            {
                Intent login=new Intent(aboutus.this,Address.class);
                startActivity(login );
                finish();
            }
            else if (id == R.id.nav_order)
            {

            } else if (id == R.id.nav_cart)
            {

            } else if (id == R.id.nav_offers)

            {

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
                Intent login=new Intent(aboutus.this,Rateus.class);
                startActivity(login );
                finish();

            }
            else if(id == R.id.nav_about)
            {
                Intent login=new Intent(aboutus.this,aboutus.class);
                startActivity(login );
                finish();

            }

            DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
            drawer.closeDrawer( GravityCompat.START );
            return true;
        }

        Element getCopyRightsElement() {
            Element copyRightsElement = new Element();
            final String copyrights = String.format(getString(R.string.about_contact_us), Calendar.getInstance().get(Calendar.YEAR));
            copyRightsElement.setTitle(copyrights);
            copyRightsElement.setIconDrawable(R.drawable.spl);
            copyRightsElement.setIconTint(mehdi.sakout.aboutpage.R.color.about_item_icon_color);
            copyRightsElement.setIconNightTint(android.R.color.white);
            copyRightsElement.setGravity( Gravity.CENTER);
            copyRightsElement.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(aboutus.this, copyrights, Toast.LENGTH_SHORT).show();
                }
            });
            return copyRightsElement;
        }

        void simulateDayNight(int currentSetting) {
            final int DAY = 0;
            final int NIGHT = 1;
            final int FOLLOW_SYSTEM = 3;

            int currentNightMode = getResources().getConfiguration().uiMode
                    & Configuration.UI_MODE_NIGHT_MASK;
            if (currentSetting == DAY && currentNightMode != Configuration.UI_MODE_NIGHT_NO) {
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_NO);
            } else if (currentSetting == NIGHT && currentNightMode != Configuration.UI_MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_YES);
            } else if (currentSetting == FOLLOW_SYSTEM) {
                AppCompatDelegate.setDefaultNightMode(
                        AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
            }
        }



    }
