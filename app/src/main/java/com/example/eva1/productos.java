package com.example.eva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.eva1.R;
import com.example.eva1.db.DbHelper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class productos extends AppCompatActivity {

    private EditText etNombre, etMarca, etPrecio, etLugarCompra, etFechaCompra, etFechaVencimiento;
    private Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtener referencias a los elementos de la interfaz
        etNombre = findViewById(R.id.et_nombre);
        etMarca = findViewById(R.id.et_marca);
        etPrecio = findViewById(R.id.et_precio);
        etLugarCompra = findViewById(R.id.et_lugar_compra);
        etFechaCompra = findViewById(R.id.et_fecha_compra);
        etFechaVencimiento = findViewById(R.id.et_fecha_vencimiento);
        btnGuardar = findViewById(R.id.btn_guardar);

        // Configurar el botón guardar
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los valores ingresados por el usuario
                String nombre = etNombre.getText().toString();
                String marca = etMarca.getText().toString();
                String precioStr = etPrecio.getText().toString();
                String lugarCompra = etLugarCompra.getText().toString();
                String fechaCompraStr = etFechaCompra.getText().toString();
                String fechaVencimientoStr = etFechaVencimiento.getText().toString();

                // Validar que los campos requeridos estén completos
                if (nombre.isEmpty() || precioStr.isEmpty()) {
                    Toast.makeText(productos.this, "Debes completar los campos de nombre y precio", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Convertir el precio a un valor numérico
                double precio = Double.parseDouble(precioStr);

                // Obtener una referencia a la base de datos en modo escritura
                DbHelper dbHelper = new DbHelper(getApplicationContext());
                SQLiteDatabase db = dbHelper.getWritableDatabase();

                // Crear un objeto ContentValues con los valores del producto
                ContentValues values = new ContentValues();
                values.put("nombre", nombre);
                values.put("marca", marca);
                values.put("precio", precio);
                values.put("lugar_compra", lugarCompra);
                values.put("fecha_compra", fechaCompraStr);
                values.put("fecha_vencimiento", fechaVencimientoStr);

                // Insertar el producto en la base de datos
                long id = db.insert(dbHelper.getTableProductos(), null, values);

                if (id != -1) {
                    Toast.makeText(productos.this, "Producto guardado con éxito", Toast.LENGTH_SHORT).show();
                    // Limpiar los campos de la interfaz
                    etNombre.setText("");
                    etMarca.setText("");
                    etPrecio.setText("");
                    etLugarCompra.setText("");
                    etFechaCompra.setText("");
                    etFechaVencimiento.setText("");
                } else {
                    Toast.makeText(productos.this, "Error al guardar el producto", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
}