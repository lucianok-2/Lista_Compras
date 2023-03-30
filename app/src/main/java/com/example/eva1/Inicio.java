package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    Button registrar;
    Button logearse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        registrar = (Button)findViewById(R.id.boton_registro);
        logearse =(Button)findViewById(R.id.boton_inicio);
        registrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent i = new Intent(Inicio.this,registro.class);
                startActivity(i);
            }
        });



    }
}