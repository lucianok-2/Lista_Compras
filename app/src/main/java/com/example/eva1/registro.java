package com.example.eva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class registro extends AppCompatActivity implements View.OnClickListener{
    Button registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        registro =(Button)findViewById(R.id.boton_registro);
        registro.setOnClickListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;


        }
        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.boton_registro:
                Intent registrar = new Intent(registro.this,lista_compra.class);
                startActivity(registrar);
                break;


        }

    }
}