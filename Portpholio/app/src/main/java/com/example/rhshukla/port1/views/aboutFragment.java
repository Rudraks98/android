package com.example.rhshukla.port1.views;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rhshukla.port1.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class aboutFragment extends Fragment {


    public aboutFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View about=inflater.inflate( R.layout.fragment_about, container, false );
        TextView aboutte=about.findViewById(R.id.about);

        return about;
    }

}
