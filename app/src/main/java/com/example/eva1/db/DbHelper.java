package com.example.eva1.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NOMBRE = "lista.db";
    public static final String TABLE_PRODUCTOS = "productos";
    private static final String TABLE_LISTAS_COMPRAS = "listas_compras";

    // Constantes de las columnas de la tabla productos
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_FECHA_COMPRA = "fecha_compra";
    public static final String COLUMN_FECHA_VENCIMIENTO = "fecha_vencimiento";
    public static final String COLUMN_LUGAR_COMPRA = "lugar_compra";
    public static final String COLUMN_MARCA = "marca";
    public static final String COLUMN_PRECIO = "precio";
    public static final String COLUMN_LISTA_COMPRAS_ID = "lista_compras_id";

    // Constantes de las columnas de la tabla listas_compras

    public static final String COLUMN_LISTA_COMPRAS_NOMBRE = "nombre";
    public static final String COLUMN_LISTA_COMPRAS_FECHA_CREACION = "fecha_creacion";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Crear la tabla de productos
        String createTableProductos = "CREATE TABLE " + TABLE_PRODUCTOS + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_NOMBRE + " TEXT NOT NULL," +
                COLUMN_FECHA_COMPRA + " TEXT," +
                COLUMN_FECHA_VENCIMIENTO + " TEXT," +
                COLUMN_LUGAR_COMPRA + " TEXT," +
                COLUMN_MARCA + " TEXT," +
                COLUMN_PRECIO + " REAL," +
                COLUMN_LISTA_COMPRAS_ID + " INTEGER," +
                "FOREIGN KEY(" + COLUMN_LISTA_COMPRAS_ID + ") REFERENCES " + TABLE_LISTAS_COMPRAS + "(" + COLUMN_LISTA_COMPRAS_ID + ")" +
                ")";
        sqLiteDatabase.execSQL(createTableProductos);

        // Crear la tabla de listas de compras
        String createTableListasCompras = "CREATE TABLE " + TABLE_LISTAS_COMPRAS + "(" +
                COLUMN_LISTA_COMPRAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_LISTA_COMPRAS_NOMBRE + " TEXT NOT NULL," +
                COLUMN_LISTA_COMPRAS_FECHA_CREACION + " TEXT NOT NULL" +
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