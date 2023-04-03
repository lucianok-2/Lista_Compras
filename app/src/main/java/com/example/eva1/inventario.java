package com.example.eva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.example.eva1.ListaProductosAdapter;
import com.example.eva1.R;

import java.util.ArrayList;

public class inventario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Cargar datos de la lista
        ArrayList<String> listaProductos = new ArrayList<>();
        listaProductos.add("Producto 1");
        listaProductos.add("Producto 2");
        listaProductos.add("Producto 3");
        listaProductos.add("Producto 4");
        listaProductos.add("Producto 5");

        // Asociar el adaptador con la lista de productos
        ListView listView = findViewById(R.id.lista_productos);
        ListaProductosAdapter adapter = new ListaProductosAdapter(this, listaProductos);
        listView.setAdapter(adapter);

        // Agregar listener para cuando se hace click en un elemento de la lista
        listView.setOnItemClickListener((parent, view, position, id) -> {
            String productoSeleccionado = listaProductos.get(position);
            Toast.makeText(getApplicationContext(), "Seleccionaste " + productoSeleccionado, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
