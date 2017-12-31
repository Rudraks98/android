package com.example.rhshukla.shopvilla;

/**customeditorunder
 * Created by RH SHUKLA on 24-12-2017.
 */



import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


public class customeditorunder   extends PagerAdapter {
    private int[] images = {R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
    private String[] name = {"lenovo","dell","Apple","hp","Assus"};
    private int[] price = {35000,25000,60000,30000,5000};
    private float[] rateing = {4,3,2,5,3};


    private Context ctx;
    private LayoutInflater inflater;

    public customeditorunder (Context ctx){
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.swipeo,container,false);

        ImageView img =(ImageView)v.findViewById(R.id.imageView);
        TextView Name = (TextView)v.findViewById(R.id.Name);
        TextView Price = (TextView)v.findViewById(R.id.price);
        TextView Rate = (TextView)v.findViewById(R.id.rating);

        img.setImageResource(images[position]);
        Name.setText("Company :"+name[position]);
        Price.setText( "Price: Rs."+price[position] );
        Rate.setText( "Rating 5/."+rateing[position] );
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent Main=new Intent( ctx,product.class );
                Main.putExtra( "photo",position);
                Main.putExtra("name",name[position]);
                Main.putExtra("price",price[position]);
                Main.putExtra("rate",rateing[position]);
                ctx.startActivity(Main);





            }
        });




        container.addView(v);
        return v;
    }

    @Override
    public void destroyItem(View container, int position, Object object) {
        container.refreshDrawableState();
    }
}
