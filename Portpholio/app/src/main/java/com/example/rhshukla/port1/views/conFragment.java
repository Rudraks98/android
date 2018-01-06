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
public class conFragment extends Fragment {


    public conFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View con= inflater.inflate( R.layout.fragment_con, container, false );

        // Inflate the layout for this fragment
        return con;
    }

}
