package com.example.proyectosprint123;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Home extends AppCompatActivity {
    private Button btnSum;
    private EditText editNum1, editNum2, editSum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnSum = (Button) findViewById(R.id.btnSum);
        editNum1  = (EditText) findViewById(R.id.editNum1);
        editNum2  = (EditText) findViewById(R.id.editNum2);
        editSum =  (EditText) findViewById(R.id.editSum);

        btnSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Obtengo los datos de las cajitas con getText() y se convierte en enteros
                int num1 = Integer.parseInt(editNum1.getText().toString().trim());
                int num2 = Integer.parseInt(editNum2.getText().toString().trim());
                // se suma los dos enteros
                int suma = num1 + num2;
                //Insertar el resultado de la suma en la caja con setText()
                //se convierte de Entero a Texto con String.valueOf()
                editSum.setText(String.valueOf(suma));
            }
        });
    }
}