package com.example.eva1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity implements View.OnClickListener{
    Button registrar;
    Button logearse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        registrar = (Button)findViewById(R.id.boton_registro);
        logearse =(Button)findViewById(R.id.boton_inicio);

        registrar.setOnClickListener(this);
        logearse.setOnClickListener(this);



    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.boton_registro:
                Intent registrar = new Intent(Inicio.this,registro.class);
                startActivity(registrar);
                break;
            case R.id.boton_inicio:
                Intent i =new Intent(Inicio.this,lista_compra.class);
                startActivity(i);
                break;

        }

    }
}