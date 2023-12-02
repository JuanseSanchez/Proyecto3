package com.example.demo.modelo;

import java.util.List;

public class TipoHabitacion {

    private String nombre;
    private int precio;
    private List<String> dotacion;

    public TipoHabitacion(String nombre, int precio, List<String> dotacion) {
        super();
        this.nombre = nombre;
        this.precio = precio;
        this.dotacion = dotacion;
    }

    public TipoHabitacion() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio= precio;
    }

    public List<String> getDotacion() {
        return dotacion;
    }

    public void setDotacion(List<String> dotacion) {
        this.dotacion = dotacion;
    }

    
}
