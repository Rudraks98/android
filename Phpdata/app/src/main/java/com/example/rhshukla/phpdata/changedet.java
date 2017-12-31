package com.example.rhshukla.phpdata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

public class changedet extends AppCompatActivity {
    private Context mContext;
    EditText name;
    EditText last;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_changedet );
        mContext = getApplicationContext();


        name = (EditText) findViewById( R.id.username);
        last = (EditText) findViewById( R.id.userlast);
        done = (Button) findViewById( R.id.update);



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                    Bundle b1 = getIntent().getExtras();
                    char s4 = b1.getChar( "enroll" );
                    String myURL = "http://10.0.2.2/jsonsys/updateinfo.php?na=" + name.getText().toString() + "&ls=" +last.getText().toString()+"&en="+s4;
                    Log.i( "URL", "Url " + myURL );


                    RequestQueue requestQueue;


                    requestQueue = Volley.newRequestQueue( mContext );

                    // Initialize a new JsonArrayRequest instance
                    JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                            Request.Method.GET,
                            myURL,
                            null,
                            new Response.Listener <JSONArray>() {
                                @Override
                                public void onResponse(JSONArray response) {
                                    Log.i( "URL", "INFO: " + response );


                                    JSONArray student = null;
                                    try {
                                        student = response.getJSONArray( 0 );

                                        String enroll = student.getString( 0 );
                                        String Name = student.getString( 1 );
                                        String Sirname = student.getString( 2 );
                                        String Email = student.getString( 3 );

                                        Intent userscreen = new Intent( mContext, UserGame.class );
                                        userscreen.putExtra( "enroll", enroll );
                                        userscreen.putExtra( "user", Name );
                                        userscreen.putExtra( "sir", Sirname );
                                        userscreen.putExtra( "email", Email );


                                        startActivity( userscreen );
                                        finish();
                                    } catch (JSONException e) {



                                    }


                                    // Get the current student (json object) data


                                }
                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    // Do something when error occurred

                                }
                            }
                    );

                    // Add JsonArrayRequest to the RequestQueue
                    requestQueue.add( jsonArrayRequest );

            }

        });






    }
}



