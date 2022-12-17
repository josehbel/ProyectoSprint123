package com.example.proyectosprint123;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.proyectosprint123.Adaptadores.ProductoAdapter;
import com.example.proyectosprint123.DB.DBFirebase;
import com.example.proyectosprint123.Entidades.Producto;

import java.util.ArrayList;

public class Catalogo extends AppCompatActivity {
    private DBFirebase dbFirebase;
    private ListView listViewProductos;
    private ProductoAdapter productoAdapter;
    private ArrayList<Producto> arrayProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalogo);

        listViewProductos = (ListView) findViewById(R.id.listViewProductos);
        arrayProductos = new ArrayList<>();
        dbFirebase = new DBFirebase();
        // creacion de productos

        Producto producto1 = new Producto("Producto1", "Desc1", 1000, R.drawable.deporte);
        Producto producto2 = new Producto("Producto2", "Desc2", 1000, R.drawable.deporte);
        Producto producto3 = new Producto("Producto3", "Desc3", 1000, R.drawable.deporte);
        Producto producto4 = new Producto("Producto4", "Desc4", 1000, R.drawable.deporte);
        Producto producto5 = new Producto("Producto5", "Desc5", 1000, R.drawable.deporte);
        Producto producto6 = new Producto("Producto6", "Desc6", 1000, R.drawable.deporte);
        Producto producto7 = new Producto("Producto7", "Desc7", 1000, R.drawable.deporte);
        Producto producto8 = new Producto("Producto8", "Desc8", 1000, R.drawable.deporte);
        Producto producto9 = new Producto("Producto9", "Desc9", 1000, R.drawable.deporte);

        dbFirebase.insertData(producto1);
        dbFirebase.insertData(producto2);
        dbFirebase.insertData(producto3);
        dbFirebase.insertData(producto4);
        dbFirebase.insertData(producto5);
        dbFirebase.insertData(producto6);
        dbFirebase.insertData(producto7);
        dbFirebase.insertData(producto8);
        dbFirebase.insertData(producto9);


        arrayProductos.add(producto1);
        arrayProductos.add(producto2);
        arrayProductos.add(producto3);
        arrayProductos.add(producto4);
        arrayProductos.add(producto5);
        arrayProductos.add(producto6);
        arrayProductos.add(producto7);
        arrayProductos.add(producto8);
        arrayProductos.add(producto9);

        productoAdapter = new ProductoAdapter(this, arrayProductos);
        listViewProductos.setAdapter(productoAdapter);

        dbFirebase.getData(productoAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addItem:
                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}