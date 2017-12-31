package com.example.rhshukla.phpdata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserGame extends AppCompatActivity {
      TextView Username;

      TextView Email;
      TextView Enroll;
      Button out;
      Button cdet;
      Button cpass;
      Button top;
    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_user_game );
        cpass=(Button)findViewById( R.id.Changep ) ;
        cdet=(Button) findViewById( R.id.changed );
        top=(Button)findViewById( R.id.top );
        Email=(TextView) findViewById( R.id.Email );
        Username=(TextView)findViewById( R.id.Name );
        Enroll=(TextView)findViewById( R.id.Enroll ) ;
        out=(Button) findViewById( R.id.button ) ;
        Bundle b1=getIntent().getExtras();

        String s1=b1.getString("user");
        String s2=b1.getString("sir");
        String s3=b1.getString("email");
        String s4=b1.getString("enroll");
        Username.setText( " :"+s1+" "+s2 );
        Email.setText(" :"+s3);
        Enroll.setText( " :"+s4 );


        top.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(UserGame.this, Top.class);

                startActivity(intent);
                finish();
            };

        });


        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sp=Enroll.getText().toString();

                int a =sp.length();
                char s= sp.charAt(a-1);


                Intent intent = new Intent(UserGame.this, Game.class);
                intent.putExtra( "enroll",s );

           startActivity(intent);
           finish();
       };

        });


        cpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sp=Enroll.getText().toString();

                int a =sp.length();
                char s= sp.charAt(a-1);

                Intent intent = new Intent(UserGame.this, conpass.class);

                intent.putExtra( "enroll",s);

                startActivity(intent);
                finish();
            };

        });

        cdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sp=Enroll.getText().toString();

                int a =sp.length();
                char s= sp.charAt(a-1);

                Intent intent = new Intent(UserGame.this, changedet.class);

                intent.putExtra( "enroll",s );

                startActivity(intent);
                finish();
            };

        });




    }


}
