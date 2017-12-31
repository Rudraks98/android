package com.example.rhshukla.phpdata;

import android.app.Activity;
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

public class Login extends AppCompatActivity {
    private Context mContext;
    private Activity mActivity;

    Button user;
    EditText Email;
    EditText Password;
    Button admin;
    Button SignUp;


    //http://localhost/jsonsys/login.php?en=rh@66.com&pass=rh123
    String baseURL = "http://10.0.2.2/jsonsys/login.php?en=";
   String  pass="&pass=";

   String adbase="http://10.0.2.2/jsonsys/adminlogin.php?en=";
    String  adpass="&pass=";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = getApplicationContext();
        mActivity = Login.this;

        user = (Button) findViewById(R.id.login);
        Email = (EditText) findViewById(R.id.Name );
        Password = (EditText) findViewById(R.id.Password);
        admin=(Button)findViewById( R.id.admin );
        SignUp=(Button) findViewById( R.id.SignUp );


        //User Login
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myURL = baseURL+Email.getText().toString()+pass+Password.getText().toString();
                Log.i("URL", "INFO: "+ myURL);

                RequestQueue requestQueue;


                requestQueue=Volley.newRequestQueue( mContext);

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
                                        try
                                        {
                                            student = response.getJSONArray( 0 );

                                            String enroll=student.getString(1);
                                            String Name = student.getString( 2 );
                                            String Sirname = student.getString( 3 );
                                            String Email = student.getString( 4 );

                                            Intent userscreen=new Intent(mContext,UserGame.class );
                                            userscreen.putExtra( "enroll",enroll );
                                            userscreen.putExtra("user",Name);
                                            userscreen.putExtra("sir",Sirname);
                                            userscreen.putExtra( "email",Email );


                                            startActivity( userscreen );
                                            finish();
                                        }
                                        catch (JSONException e)
                                        {
                                            try {
                                                String s=response.getString(0);

                                                if(s.equals("Not User"))
                                                {
                                                    Toast toast = Toast.makeText(mContext, "Worng id or password",LENGTH_SHORT);
                                                    toast.show();
                                                }
                                                else
                                                {
                                                    Toast toast = Toast.makeText(mContext, "Denied By admin",LENGTH_SHORT);
                                                    toast.show();
                                                }


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






        //Admin Login
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String myURL = adbase+Email.getText().toString()+adpass+Password.getText().toString();
                Log.i("URL", "INFO: "+ myURL);

                RequestQueue requestQueue;


                requestQueue=Volley.newRequestQueue( mContext);

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
                                try
                                {
                                    student = response.getJSONArray( 0 );

                                   // String enroll=student.getString(0);
                                   // String Name = student.getString( 1 );
                                   // String Sirname = student.getString( 2 );
                                   // String Email = student.getString( 3 );

                                    Intent admin=new Intent(mContext,Adminpanel.class );
                                   // userscreen.putExtra( "enroll",enroll );
                                   // userscreen.putExtra("user",Name);
                                   // userscreen.putExtra("sir",Sirname);
                                   // userscreen.putExtra( "email",Email );


                                    startActivity( admin );
                                    finish();
                                }
                                catch (JSONException e)
                                {
                                    try {
                                        String s=response.getString(0);

                                        if(s.equals("Not Admin"))
                                        {
                                            Toast toast = Toast.makeText(mContext, "Worng id or password",LENGTH_SHORT);
                                            toast.show();
                                        }
                                        else
                                        {
                                            Toast toast = Toast.makeText(mContext, "Denied By admin",LENGTH_SHORT);
                                            toast.show();
                                        }


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


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent signup=new Intent(mContext,SignUP.class );
                startActivity( signup );

            }
        });


    }
}