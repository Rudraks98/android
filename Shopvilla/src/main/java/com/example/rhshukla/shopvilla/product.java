package com.example.rhshukla.shopvilla;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class product extends AppCompatActivity {

    TextView n;
    TextView p;
    TextView r;
    ImageView pi;
    private int[] images = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
    Button buy;
    Button back;
    Button cart;
    private int[] price = {35000,25000,60000,30000,5000};
    private float[] rateing = {4,3,2,5,3};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_product );

        n=(TextView)findViewById( R.id.Name ) ;
        p=(TextView)findViewById( R.id.price) ;
        r=(TextView)findViewById( R.id.rate ) ;
        pi=(ImageView)findViewById( R.id.product ) ;


        Bundle b1 = getIntent().getExtras();
        int img = b1.getInt( "photo" );
        String Name= b1.getString( "name" );

        String pr= String.valueOf( price[img] );
        String ra= String.valueOf( rateing[img] );


        n.setText( Name );
        pi.setImageResource(images[img]);
        p.setText(pr);
        r.setText( ra);


        buy=(Button)findViewById( R.id.buy );
        back=(Button)findViewById( R.id.back);
        cart=(Button)findViewById( R.id.cart);

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent Main=new Intent( product.this,MainActivity.class );
                startActivity( Main  );

            }



        });

        buy.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Main=new Intent( product.this,Order.class );
                startActivity( Main  );

            }
        } );

        cart.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Main=new Intent( product.this,yourcart.class );
                startActivity( Main  );
            }
        } );










    }

}
