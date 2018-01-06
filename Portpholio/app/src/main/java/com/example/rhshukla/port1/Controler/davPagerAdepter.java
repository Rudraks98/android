package com.example.rhshukla.port1.Controler;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.rhshukla.port1.views.aboutFragment;
import com.example.rhshukla.port1.views.conFragment;
import com.example.rhshukla.port1.views.skillFragment;
import com.example.rhshukla.port1.views.workFragment;

/**
 * Created by RH SHUKLA on 01-01-2018.
 */

public class davPagerAdepter extends FragmentPagerAdapter {

    public davPagerAdepter(FragmentManager fm) {
        super( fm );
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new aboutFragment();
            case 1:
                return new skillFragment();
            case 2:
                return new workFragment();
            case 3:
                return new conFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position)
        {
            case 0:
                return "ABOUT";
            case 1:
                return "SKILLS";
            case 2:
                return"WORK";
            case 3:
                return "Contact";
        }
        return super.getPageTitle( position );
    }
}
