package com.example.rhshukla.shopvilla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

import static android.widget.Toast.LENGTH_SHORT;

public class signup extends AppCompatActivity {
    private static final String TAG = "SignupActivity";

   EditText _nameText;

    EditText _addressText;
   EditText _emailText;
     EditText _mobileText;
   EditText _passwordText;
    EditText _reEnterPasswordText;
     Button _signupButton;
    TextView _loginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_signup );

        _nameText=(EditText)findViewById( (R.id.input_name) ) ;
        _addressText=(EditText)findViewById (R.id.input_address)  ;
        _emailText=(EditText)findViewById (R.id.input_email)  ;
        _mobileText=(EditText)findViewById (R.id.input_mobile)  ;
        _passwordText=(EditText) findViewById (R.id.input_password)  ;
        _reEnterPasswordText=(EditText) findViewById (R.id.input_reEnterPassword);
        _signupButton=(Button) findViewById(R.id.btn_signup  );
        _loginLink=(TextView)findViewById( R.id.link_login) ;








        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent intent = new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_in);
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }
        else
        {
            onSignupSuccess();
        }

        _signupButton.setEnabled(false);







        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onSignupSuccess or onSignupFailed
                        // depending on success
                        onSignupSuccess();
                        // onSignupFailed();

                    }
                }, 3000);
    }


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        String myURL = "http://10.0.2.2/shopvilla/reg.php?fn=" + _nameText.getText().toString() + "&add=" +_addressText.getText().toString() + "&em=" +  _emailText.getText().toString() + "&pa=" + _passwordText.getText().toString() + "&mo=" +  _mobileText.getText().toString();
        Log.i( "URL", "Url " + myURL );

        RequestQueue requestQueue;


        requestQueue = Volley.newRequestQueue( signup.this );

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


                        Toast toast = Toast.makeText( signup.this, "Welcom User", LENGTH_SHORT );
                        toast.show();
                        Intent admin = new Intent( signup.this, Login.class );
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



        finish();
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();

        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String address = _addressText.getText().toString();
        String email = _emailText.getText().toString();
        String mobile = _mobileText.getText().toString();
        String password = _passwordText.getText().toString();
        String reEnterPassword = _reEnterPasswordText.getText().toString();

        if (name.isEmpty() || name.length() < 3) {
            _nameText.setError("at least 3 characters");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (address.isEmpty()) {
            _addressText.setError("Enter Valid Address");
            valid = false;
        } else {
            _addressText.setError(null);
        }


        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("enter a valid email address");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (mobile.isEmpty() || mobile.length()!=10) {
            _mobileText.setError("Enter Valid Mobile Number");
            valid = false;
        } else {
            _mobileText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("between 4 and 10 alphanumeric characters");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        if (reEnterPassword.isEmpty() || reEnterPassword.length() < 4 || reEnterPassword.length() > 10 || !(reEnterPassword.equals(password))) {
            _reEnterPasswordText.setError("Password Do not match");
            valid = false;
        } else {
            _reEnterPasswordText.setError(null);
        }

        return valid;
    }
}