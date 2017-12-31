package com.example.rhshukla.phpdata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import static android.widget.Toast.LENGTH_SHORT;

public class Game extends AppCompatActivity {
    int aplayer=1;
    int[] state={2,2,2,2,2,2,2,2,2};
    //0 for cross
    EditText po;
    Button add;
    int winp;

    public void rzcz(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;

        }

        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );

            }
            else
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
        }

    }




    public void rzco(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;
        }

        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);

            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );
            }
            else if(winplayer==0)
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, " is win",LENGTH_SHORT);
                toast.show();
            }
        }


    }

    public void rzct(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;

        }
        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );
            }
            else if(winplayer==0)
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, " is win",LENGTH_SHORT);
                toast.show();
            }
        }


    }

    public void rocz(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;

            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;
        }
        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );
            }
            else if(winplayer==0)
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, " is win",LENGTH_SHORT);
                toast.show();
            }
        }


    }

    public void roco(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;

        }
        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );
            }
            else if(winplayer==0)
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, " is win",LENGTH_SHORT);
                toast.show();
            }
        }


    }

    public void roct(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;

        }

        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );
            }
            else if(winplayer==0)
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, " is win",LENGTH_SHORT);
                toast.show();
            }

        }


    }

    public void rtcz(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;

        }
        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );
            }
            else if(winplayer==0)
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, " is win",LENGTH_SHORT);
                toast.show();
            }
        }


    }

    public void rtco(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;
        }
        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
                putdata( "xwin" );
            }
            else if(winplayer==0)
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
                putdata( "ywin" );
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, " is win",LENGTH_SHORT);
                toast.show();
            }

        }


    }

    public void rtct(View v)
    {
        ImageView a=(ImageView) v;
        int temp= Integer.parseInt( a.getTag().toString());
        if(state[temp]==2)
        {
            if (aplayer == 0) {
                a.setImageResource(R.drawable.cross);
                a.animate().rotation(360).setDuration(1000);
                aplayer = 1;
            } else {
                a.setImageResource(R.drawable.circle);
                a.animate().setDuration(1000);
                aplayer = 0;
            }
            state[temp]=aplayer;

        }
        winp=win( state );

        if(winp!=10)
        {
            int winplayer=state[winp];
            Log.i("arr","hi"+state[winp]);
            if(winplayer==1)
            {
                Toast toast = Toast.makeText(Game.this, "cross is win",LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(Game.this, "circle is win",LENGTH_SHORT);
                toast.show();
            }
        }



    }

    public void re(View v)
    {
        int i=0;
        for(i=0;i<9;i++)
        {
            state[i]=2;
        }

        aplayer=0;

        LinearLayout l1=(LinearLayout) findViewById(R.id.lineo);

        for(i=0;i<l1.getChildCount();i++) {
            ((ImageView) l1.getChildAt(i)).setImageResource(R.drawable.empty);
        }


        LinearLayout l2=(LinearLayout) findViewById(R.id.linet);
        for(i=0;i<l2.getChildCount();i++) {
            ((ImageView) l2.getChildAt(i)).setImageResource(R.drawable.empty);
        }
        LinearLayout l3=(LinearLayout) findViewById(R.id.lineth);


        for(i=0;i<l3.getChildCount();i++) {
            ((ImageView) l3.getChildAt(i)).setImageResource(R.drawable.empty);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_game );

        po=(EditText)findViewById( R.id.point );
        add=(Button)findViewById( R.id.addpoint );

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Bundle b1 = getIntent().getExtras();
                char s4 = b1.getChar( "enroll" );
                String a=po.getText().toString();

                String myURL = "http://10.0.2.2/jsonsys/point.php?en="+s4+"&po="+a;
                Log.i( "URL", "Url " + myURL );

                RequestQueue requestQueue;


                requestQueue= Volley.newRequestQueue(Game.this);

                // Initialize a new JsonArrayRequest instance
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                        Request.Method.GET,
                        myURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Log.i("URL", "INFO: "+ response );


                                JSONArray student = null;


                                    Toast toast = Toast.makeText(Game.this, "point add ",LENGTH_SHORT);
                                    toast.show();











                                // Get the current student (json object) data


                            }
                        },
                        new Response.ErrorListener(){
                            @Override
                            public void onErrorResponse(VolleyError error){
                                // Do something when error occurred

                            }
                        }
                );

                // Add JsonArrayRequest to the RequestQueue
                requestQueue.add(jsonArrayRequest);
            }
        });





    }

    public int win(int [] a)
    {
        if(a[0]==a[1])
        {
            if(a[1]==a[2])
            {
                if(a[2]!=2)
                {
                    return 0;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }

        else if(a[0]==a[3])
        {
            if(a[3]==a[6])
            {
                if(a[6]!=2)
                {
                    return 0;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }

        else if(a[0]==a[4])
        {
            if(a[4]==a[8])
            {
                if(a[8]!=2)
                {
                    return 0;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }




        else if(a[1]==a[4])
        {
            if(a[4]==a[7])
            {
                if(a[7]!=2)
                {
                    return 1;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }



        else if(a[2]==a[4])
        {
            if(a[4]==a[6])
            {
                if(a[6]!=2)
                {
                    return 2;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }


        else if(a[2]==a[5])
        {
            if(a[5]==a[8])
            {
                if(a[8]!=2)
                {
                    return 2;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }



        else if(a[3]==a[4])
        {
            if(a[4]==a[5])
            {
                if(a[5]!=2)
                {
                    return 3;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }

        else if(a[6]==a[7])
        {
            if(a[7]==a[8])
            {
                if(a[8]!=2)
                {
                    return 8;
                }
                else
                {
                    return 10;
                }
            }
            else
            {
                return 10;
            }
        }


        else
        {
            return 10;
        }



    }


   public void putdata(String s)
    {
        Bundle b1 = getIntent().getExtras();
        char s4 = b1.getChar( "enroll" );
        String a=po.getText().toString();

        String myURL = "http://10.0.2.2/jsonsys/pipoint.php?en="+s4+"&po="+s;
        Log.i( "URL", "Url " + myURL );

        RequestQueue requestQueue;


        requestQueue= Volley.newRequestQueue(Game.this);

        // Initialize a new JsonArrayRequest instance
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                myURL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("URL", "INFO: "+ response );


                        JSONArray student = null;


                        Toast toast = Toast.makeText(Game.this, "point add ",LENGTH_SHORT);
                        toast.show();











                        // Get the current student (json object) data


                    }
                },
                new Response.ErrorListener(){
                    @Override
                    public void onErrorResponse(VolleyError error){
                        // Do something when error occurred

                    }
                }
        );

        // Add JsonArrayRequest to the RequestQueue
        requestQueue.add(jsonArrayRequest);
    }







}
