package com.example.rhshukla.port1.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rhshukla.port1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class skillFragment extends Fragment {


    public skillFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View skill=inflater.inflate( R.layout.fragment_skill, container, false );

        return skill;
    }

}
