package com.example.eva1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class recordatorio extends AppCompatActivity {

    private EditText descripcionEditText;
    private EditText fechaEditText;
    private Button agregarRecordatorioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordatorio);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Obtener referencias a los elementos en el layout
        descripcionEditText = findViewById(R.id.descripcionEditText);
        fechaEditText = findViewById(R.id.fechaEditText);
        agregarRecordatorioButton = findViewById(R.id.agregarRecordatorioButton);

        // Agregar listener al botón de agregar recordatorio
        agregarRecordatorioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados por el usuario
                String descripcion = descripcionEditText.getText().toString();
                String fecha = fechaEditText.getText().toString();

                // Validar que los datos no estén vacíos
                if (descripcion.isEmpty() || fecha.isEmpty()) {
                    Toast.makeText(recordatorio.this, "Ingrese todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Obtener la fecha actual y convertirla al formato deseado
                String fechaActual = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault()).format(Calendar.getInstance().getTime());

                // Mostrar un mensaje con los datos del recordatorio agregado
                String mensaje = "Recordatorio agregado:\n" +
                        "Descripción: " + descripcion + "\n" +
                        "Fecha: " + fecha + "\n" +
                        "Fecha de creación: " + fechaActual;
                Toast.makeText(recordatorio.this, mensaje, Toast.LENGTH_LONG).show();
            }
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