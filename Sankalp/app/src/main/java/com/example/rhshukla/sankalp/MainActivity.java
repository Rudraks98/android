package com.example.rhshukla.sankalp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.rhshukla.sankalp.data.QuoteData;
import com.example.rhshukla.sankalp.data.QuoteListAsyncResponse;
import com.example.rhshukla.sankalp.data.QuoteViewPagerAdpater;
import com.example.rhshukla.sankalp.model.Quote;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private QuoteViewPagerAdpater quoteViewPagerAdpater;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quoteViewPagerAdpater = new QuoteViewPagerAdpater(getSupportFragmentManager(), getFragments());

        viewPager = findViewById(R.id.ViewPager);
        viewPager.setAdapter(quoteViewPagerAdpater);


    }


    private List<Fragment> getFragments() {
        final List<Fragment> fragmentList = new ArrayList<>();
        new QuoteData().getQuotes( new QuoteListAsyncResponse() {
            @Override
            public void processFinished(ArrayList<Quote> quotes) {
                for (int i = 0; i < quotes.size(); i++) {
                    QuoteFragment quoteFragment = QuoteFragment.newInstance(
                            quotes.get(i).getQuote(),
                            quotes.get(i).getAuthor()
                    );
                    fragmentList.add(quoteFragment);
                }
                quoteViewPagerAdpater.notifyDataSetChanged();/// very important!!

            }
        });




        return fragmentList;
    }
}
