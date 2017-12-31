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

import static android.widget.Toast.LENGTH_SHORT;

public class SignUP extends AppCompatActivity {
    EditText Name;
    EditText LastName;
    EditText Password;
    EditText Gender;
    EditText email;
    EditText Enroll;
    Button signup;
    EditText  con;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_sign_up );
        mContext = getApplicationContext();

        con=(EditText)findViewById( R.id.editConform ) ;
        Name=(EditText)findViewById( R.id.editfirstName );
        LastName=(EditText)findViewById( R.id.editlastName );
        Password=(EditText)findViewById( R.id.editTextPassword);
        email=(EditText)findViewById( R.id.editTextEmail );
        Gender=(EditText)findViewById( R.id.editGender );
        Enroll=(EditText)findViewById( R.id.editenrollment );
        signup=(Button)findViewById( R.id.Submit ) ;
        //http://localhost/jsonsys/signup.php?fn=riya&ls=lakhani&em=riya@27.com&pa=riya123&ge=femail&en=6


        final String Email=con.getText().toString();
        final String Pass=Password.getText().toString();

        if(Email.equals( Pass )) {


            signup.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String myURL = "http://10.0.2.2/jsonsys/signup.php?fn=" + Name.getText().toString() + "&ls=" + LastName.getText().toString() + "&em=" + email.getText().toString() + "&pa=" + Password.getText().toString() + "&ge=" + Gender.getText().toString() + "&en=" + Enroll.getText().toString();
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


                                        Toast toast = Toast.makeText( mContext, "Welcom User", LENGTH_SHORT );
                                        toast.show();
                                        Intent admin = new Intent( mContext, Login.class );
                                        startActivity( admin );



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
            } );
        }
        else
        {
            Toast toast = Toast.makeText( mContext, "Password not match", LENGTH_SHORT );
            toast.show();
        }


    }
}
