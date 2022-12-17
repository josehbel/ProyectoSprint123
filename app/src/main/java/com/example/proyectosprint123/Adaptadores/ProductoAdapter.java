package com.example.proyectosprint123.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.proyectosprint123.Entidades.Producto;
import com.example.proyectosprint123.R;

import java.util.ArrayList;

public class ProductoAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Producto> arrayProducto;

    public ProductoAdapter(Context context, ArrayList<Producto> arrayProducto) {
        this.context = context;
        this.arrayProducto = arrayProducto;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ArrayList<Producto> getArrayProducto() {
        return arrayProducto;
    }

    public void setArrayProducto(ArrayList<Producto> arrayProducto) {
        this.arrayProducto = arrayProducto;
    }

    @Override
    public int getCount() {
        return arrayProducto.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayProducto.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        //*Referenciar el template de producto
        view = layoutInflater.inflate(R.layout.producto_template,null);

        ImageView imgProducto = (ImageView) view.findViewById(R.id.imgProducto);
        TextView textName = (TextView) view.findViewById(R.id.textName);
        TextView textDescription = (TextView) view.findViewById(R.id.textDescription);
        TextView textPrice = (TextView) view.findViewById(R.id.textPrice);

        Producto producto = arrayProducto.get(i);

        imgProducto.setImageResource(producto.getImage());
        textName.setText(producto.getName());
        textDescription.setText(producto.getDescription());
        //se debe convertir el entero de price a String
        textPrice.setText(String.valueOf(producto.getPrice()));

        return view;
    }
}
