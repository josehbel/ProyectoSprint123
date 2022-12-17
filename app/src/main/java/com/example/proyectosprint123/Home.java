package com.example.proyectosprint123;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.proyectosprint123.DB.DBFirebase;
import com.example.proyectosprint123.Entidades.Producto;

public class Home extends AppCompatActivity {
    private Button btnForm;
    private EditText editName, editDescription, editPrice;
    private DBFirebase dbFirebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnForm = (Button) findViewById(R.id.btnForm);
        editName  = (EditText) findViewById(R.id.editName);
        editDescription  = (EditText) findViewById(R.id.editDescription);
        editPrice =  (EditText) findViewById(R.id.editPrice);
        dbFirebase = new DBFirebase();

        btnForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Producto producto = new Producto (
                        editName.getText().toString(),
                        editDescription.getText().toString(),
                        Integer.parseInt(editPrice.getText().toString()),
                        R.drawable.deporte
                );
                dbFirebase.insertData(producto);
                Intent intent = new Intent(getApplicationContext(), Catalogo.class);
                startActivity(intent);
            }
        });
    }
}