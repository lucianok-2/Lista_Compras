package com.example.eva1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "lista.db";
    private static final String TABLE_PRODUCTOS = "productos";
    private static final String TABLE_LISTAS_COMPRAS = "listas_compras";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Crear la tabla de productos
        String createTableProductos = "CREATE TABLE " + TABLE_PRODUCTOS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "fecha_compra TEXT," +
                "fecha_vencimiento TEXT," +
                "lugar_compra TEXT," +
                "marca TEXT," +
                "precio REAL," +
                "lista_compras_id INTEGER," +
                "FOREIGN KEY(lista_compras_id) REFERENCES " + TABLE_LISTAS_COMPRAS + "(id)" +
                ")";
        sqLiteDatabase.execSQL(createTableProductos);

        // Crear la tabla de listas de compras
        String createTableListasCompras = "CREATE TABLE " + TABLE_LISTAS_COMPRAS + "(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "fecha_creacion TEXT NOT NULL" +
                ")";
        sqLiteDatabase.execSQL(createTableListasCompras);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    // Método para obtener el nombre de la tabla de productos
    public String getTableProductos() {
        return TABLE_PRODUCTOS;
    }
}
