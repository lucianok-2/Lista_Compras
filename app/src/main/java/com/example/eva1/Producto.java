package com.example.eva1;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private String fechaVencimiento;
    private String fechaCompra;
    private String marca;
    private String lugarCompra;

    public Producto(int id, String nombre, double precio, String fechaVencimiento, String fechaCompra, String marca, String lugarCompra) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaCompra = fechaCompra;
        this.marca = marca;
        this.lugarCompra = lugarCompra;
    }

    // Getters y setters para los atributos

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getLugarCompra() {
        return lugarCompra;
    }

    public void setLugarCompra(String lugarCompra) {
        this.lugarCompra = lugarCompra;
    }
}
