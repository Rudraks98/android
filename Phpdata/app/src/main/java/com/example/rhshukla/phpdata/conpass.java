package com.example.rhshukla.phpdata;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;

import static android.widget.Toast.LENGTH_SHORT;

public class conpass extends AppCompatActivity {
    EditText enter;
    Button change;
    private Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_conpass );
        mContext = getApplicationContext();

        enter=(EditText)findViewById( R.id.usere );
        change=(Button)findViewById( R.id.check );


        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // http://localhost/jsonsys/cpassword.php?en=4
                Bundle b1=getIntent().getExtras();
                char s4=b1.getChar("enroll");

                String myURL = "http:/10.0.2.2/jsonsys/cpassword.php?en="+s4;
                Log.i("URL", "INFO: "+ myURL);

                RequestQueue requestQueue;


                requestQueue= Volley.newRequestQueue( mContext);

                // Initialize a new JsonArrayRequest instance
                JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                        Request.Method.GET,
                        myURL,
                        null,
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                Log.i("URL", "INFO: "+ response );



                                try
                                {
                                    String password = response.getString( 0 );
                                    String s=enter.getText().toString();
                                    Log.i("URL", "INFO: "+ s );


                                    if(s.equals( password ))
                                    {
                                        Bundle b1=getIntent().getExtras();
                                        char s4=b1.getChar("enroll");

                                        Intent admin=new Intent(mContext,Newpass.class );
                                         admin.putExtra( "enroll",s4);
                                        // userscreen.putExtra("user",Name);
                                        // userscreen.putExtra("sir",Sirname);
                                        // userscreen.putExtra( "email",Email );


                                        startActivity( admin );
                                        finish();
                                    }

                                    else
                                    {
                                        Toast toast = Toast.makeText(mContext, "Worng password",LENGTH_SHORT);
                                        toast.show();
                                    }


                                }
                                catch (JSONException e)
                                {
                                    try {
                                        String s=response.getString(0);



                                            Toast toast = Toast.makeText(mContext, "Worng id or password",LENGTH_SHORT);
                                            toast.show();



                                    }
                                    catch (JSONException e1)
                                    {
                                        e1.printStackTrace();
                                    }


                                }



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
}
