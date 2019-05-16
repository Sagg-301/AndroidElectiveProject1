package com.example.miniproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.miniproyecto.Entities.Item;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ArrayList con los elementos del carrito
    ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Integer> item_images = new ArrayList<Integer>();

    //List view para mostrar la lista de elementos del carrito
    ListView items_list;

    //Objeto usado para almacenar los objetos de la tienda
    ItemCardAdapter list_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Busca los intents
        Intent intent = getIntent();
        ArrayList<Item> intentItems = (ArrayList<Item>) intent.getSerializableExtra("items");
        ArrayList<Integer> images = (ArrayList<Integer>)intent.getSerializableExtra("images");

        //Si se trajo un intent con un elemento del carrito lo añade a la lista
        if(intentItems != null && items.size() < 10){

            //Añade a los arrays
            items = intentItems ;
            item_images = images;

            list_adapter = new ItemCardAdapter(this,items, item_images);

            //Asigna la lista de objetos al listview
            items_list = (ListView) findViewById(R.id.list_viewhome);

            //Setea la lista de objetos al listview
            items_list.setAdapter(list_adapter);

        }



    }


    /**
     * Se traslada a la segunda actividad
     */
    public void launchSecondActivity(View view) {

        Intent intent = new Intent(this, ItemListActivity.class);
        intent.putExtra("savedItems", this.items);
        intent.putExtra("savedImages", this.item_images);
        startActivity(intent);

    }


}
