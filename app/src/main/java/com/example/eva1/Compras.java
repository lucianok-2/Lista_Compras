package com.example.eva1;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eva1.db.DbHelper;


public class Compras extends AppCompatActivity implements View.OnClickListener {

    private EditText etBuscar;
    private Button btnBuscar, btnAñadir, btnEditar, btnEliminar;
    private RecyclerView recyclerView;
    private List<Producto> listaProductos;
    private ProductosAdapter adapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtener referencias a los elementos de la interfaz
        etBuscar = findViewById(R.id.et_buscar);
        btnBuscar = findViewById(R.id.btn_buscar);
        btnAñadir = findViewById(R.id.btn_añadir);
        btnEditar = findViewById(R.id.btn_editar);
        btnEliminar = findViewById(R.id.btn_eliminar);
        recyclerView = findViewById(R.id.recyclerView);

        // Configurar el RecyclerView
        listaProductos = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new ProductosAdapter(this, listaProductos);
        recyclerView.setAdapter(adapter);

        // Configurar los botones
        btnBuscar.setOnClickListener(this);
        btnAñadir.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_buscar:
                // Código para buscar productos
                break;
            case R.id.btn_añadir:
                Intent intent = new Intent(this, productos.class);
                startActivity(intent);
                break;
            case R.id.btn_editar:
                // Código para editar productos
                break;
            case R.id.btn_eliminar:
                // Código para eliminar productos
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Cargar los productos desde la base de datos
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(dbHelper.TABLE_PRODUCTOS, null, null, null, null, null, null);
        listaProductos.clear();

        while (cursor.moveToNext()) {
            int id = cursor.getInt(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_ID));
            String nombre = cursor.getString(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_NOMBRE));
            double precio = cursor.getDouble(cursor.getColumnIndexOrThrow(DbHelper.COLUMN_PRECIO));
            // Agregar los datos del producto a la lista
            listaProductos.add(new Producto(id, nombre, precio));
        }

        cursor.close();
        db.close();

        // Notificar al adaptador que los datos han cambiado
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}