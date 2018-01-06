package com.example.rhshukla.sankalp.data;

/**
 * Created by RH SHUKLA on 05-01-2018.
 */

import com.example.rhshukla.sankalp.model.Quote;

import java.util.ArrayList;



/**
 * Created by paulodichone on 11/8/17.
 */

public interface QuoteListAsyncResponse {
    void processFinished(ArrayList<Quote> quotes);
}
