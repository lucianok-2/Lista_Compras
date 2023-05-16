package com.example.eva1;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String fechaVencimiento;

    public Producto(int id, String nombre, double precio, String fechaVencimiento) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }
}
