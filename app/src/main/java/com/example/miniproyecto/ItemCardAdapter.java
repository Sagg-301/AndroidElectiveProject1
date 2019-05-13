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

import java.util.ArrayList;

public class ItemCardAdapter extends BaseAdapter {
    private ArrayList<Item> result;
    private ArrayList<Integer> image_id;

    private Context context;
    private ItemListActivity itemListActivity;
    private MainActivity mainActivity;


    private static LayoutInflater inflater = null;



    ItemCardAdapter(ItemListActivity itemListActivity, ArrayList<Item> items, ArrayList<Integer> images ) {
        this.result=items;
        this.context=itemListActivity;
        this.itemListActivity=itemListActivity;
        this.image_id = images;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    ItemCardAdapter(MainActivity mainActivity, ArrayList<Item> items, ArrayList<Integer> images ) {
        this.result=items;
        this.context=mainActivity;
        this.mainActivity=mainActivity;
        this.image_id = images;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return result.size();
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

        holder.cardtitle.setText(result.get(position).getName());
        holder.carddescription.setText(result.get(position).getDescription());
        holder.price.setText( "Precio: "+Double.toString(result.get(position).getPrice())+"$" );
        Picasso.with(context).load(image_id.get(position)).into(holder.image);

        view.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {


            Toast.makeText(context, "Clickeaste " + result.get(position), Toast.LENGTH_LONG).show();


            if(itemListActivity != null){

                itemListActivity.launchMainActivity(result.get(position), image_id.get(position));

            }


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
