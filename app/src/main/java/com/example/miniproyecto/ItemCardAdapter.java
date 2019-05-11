package com.example.miniproyecto;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.miniproyecto.Entities.Item;
import com.squareup.picasso.Picasso;

public class ItemCardAdapter extends BaseAdapter {
    Item [] result;
    Context context;
    int[] image_id;
    private static LayoutInflater inflater=null;

    public ItemCardAdapter(MainActivity mainActivity, Item[] items, int[] images) {
        this.result=items;
        this.context=mainActivity;
        this.image_id = images;
        this.inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder=new Holder();
        View view;
        view = inflater.inflate(R.layout.itemcard, null);

        holder.cardtitle=(TextView) view.findViewById(R.id.cardtitle);
        holder.carddescription = (TextView) view.findViewById(R.id.description);
        holder.price = (TextView) view.findViewById(R.id.price);
        holder.image=(ImageView) view.findViewById(R.id.item_image);

        holder.cardtitle.setText(result[position].getName());
        holder.carddescription.setText(result[position].getDescription());
        holder.price.setText( "Precio: "+Double.toString(result[position].getPrice())+"$" );
        Picasso.with(context).load(image_id[position]).into(holder.image);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clickeaste " + result[position], Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

    public class Holder
    {
        TextView cardtitle;
        TextView carddescription;
        TextView price;
        ImageView image;
    }
}
