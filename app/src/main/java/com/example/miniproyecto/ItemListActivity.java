package com.example.miniproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.example.miniproyecto.Entities.Item;


import java.util.ArrayList;

public class ItemListActivity extends AppCompatActivity {


    //List view para mostrar la data
    ListView items_list;

    //Objeto usado para almacenar los objetos de la tienda
    ItemCardAdapter list_adapter;


    public static ArrayList<Item> items = new ArrayList<Item>(){{
        add(new Item("Zapatos", "Zapatos deportivos nike", 16.7, 1));
        add(new Item("Camisa", "Camisa de vestir", 10.5, 2));
        add(new Item("Leggings", "Leggins para dama", 10, 3));
        add(new Item("Pantalones", "Pantalones jean", 20, 4));
        add(new Item("Gorra", "Gorra addidas", 5.99, 5));
        add(new Item("Guantes", "Guantes para el frio", 2.99, 6));
        add(new Item("Hoodie", "Hoodie quiksilver", 5.99, 7));
        add(new Item("Chaqueta", "Chaqueta de cuero", 50.99, 8));
    }};


    public static ArrayList<Integer> item_images = new ArrayList<Integer>(){{
        add(new Integer(R.drawable.shoes) ) ;
        add(new Integer(R.drawable.shirt));
        add(new Integer(R.drawable.leggings));
        add(new Integer(R.drawable.pants));
        add(new Integer(R.drawable.cap));
        add(new Integer(R.drawable.gloves));
        add(new Integer(R.drawable.hoodie));
        add(new Integer(R.drawable.jacket));
        add(new Integer(R.mipmap.ic_launcher));
    }};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        //Prepara los datos
        init();

        //Setea la lista de objetos al listview
        items_list.setAdapter(list_adapter);

    }

    /**
     * Prepara la lista de objetos para ser mostrados
     */
    private void init() {

        //Instancia la lista con las items y sus respectivas imagenes
        list_adapter = new ItemCardAdapter(this,items, item_images);

        //Asigna la lista de objetos al listview
        items_list = (ListView) findViewById(R.id.list_view);
    }


    /**
     * Se mueve a la primera activity y envía el objeto selecionado
     * @param item: item con los datos del elemento del carrito
     * @param image: número de la imagen
     */
    public void launchMainActivity(Item item, int image) {

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("item", item);
        intent.putExtra("image", image);
        startActivity(intent);
    }

}
