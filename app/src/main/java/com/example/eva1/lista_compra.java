package com.example.eva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class lista_compra extends AppCompatActivity implements View.OnClickListener{
    Button lista;
    Button productos;
    Button inventario;
    Button recordatorio;
    Button lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_compra);
        lista = (Button)findViewById(R.id.boton_inicio3);
        lista.setOnClickListener(this);
        productos =(Button)findViewById(R.id.boton_inicio6);
        productos.setOnClickListener(this);
        inventario = (Button)findViewById(R.id.boton_inicio5);
        inventario.setOnClickListener(this);
        recordatorio =(Button)findViewById(R.id.boton_inicio7);
        recordatorio.setOnClickListener(this);
        lugar =(Button)findViewById(R.id.boton_inicio4);
        lugar.setOnClickListener(this);




        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.boton_inicio3:
                Intent i = new Intent(lista_compra.this,Compras.class);
                startActivity(i);
                break;
            case R.id.boton_inicio6:
                Intent c = new Intent(lista_compra.this,productos.class);
                startActivity(c);
                break;
            case R.id.boton_inicio5:
                Intent in = new Intent(lista_compra.this,inventario.class);
                startActivity(in);
                break;
            case R.id.boton_inicio7:
                Intent r = new Intent(lista_compra.this, recordatorio.class);
                startActivity(r);
                break;
            case R.id.boton_inicio4:
                Intent l = new Intent(lista_compra.this,lugares.class);
                startActivity(l);
                break;
        }

    }
}