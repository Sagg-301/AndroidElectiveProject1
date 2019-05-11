package com.example.miniproyecto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.miniproyecto.Entities.Item;

public class MainActivity extends AppCompatActivity {

    ListView items_list;
    ItemCardAdapter list_adapter;
    Item[] items = new Item[] { new Item("Zapatos", "Zapatos deportivos nike", 16.7, 1),
            new Item("Camisa", "Camisa de vestir", 10.5, 2),
            new Item("Leggings", "Leggins para dama", 10, 3),
            new Item("Pantalones", "Pantalones jean", 20, 4),
            new Item("Gorra", "Gorra addidas", 5.99, 5),
            new Item("Guantes", "Guantes para el frio", 2.99, 6),
            new Item("Hoodie", "Hoodie quiksilver", 5.99, 7),
            new Item("Chaqueta", "Chaqueta de cuero", 50.99, 8)};
    public static int [] item_images={R.drawable.shoes,
            R.drawable.shirt,
            R.drawable.leggings,
            R.drawable.pants,
            R.drawable.cap,
            R.drawable.gloves,
            R.drawable.hoodie,
            R.drawable.jacket,
            R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        items_list.setAdapter(list_adapter);
    }

    private void init() {

        list_adapter = new ItemCardAdapter(this,items, item_images);
        items_list = (ListView) findViewById(R.id.list_view);
    }

}
