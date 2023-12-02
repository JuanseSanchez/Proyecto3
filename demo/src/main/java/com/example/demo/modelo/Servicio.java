package com.example.demo.modelo;

import org.bson.BsonDateTime;

public class Servicio {

    private String nombre;
    private BsonDateTime fecha;
    private int precio;

    public Servicio(BsonDateTime fecha, int precio){
        super();
        this.fecha = fecha;
        this.precio = precio;
    }

    public Servicio() {
        super();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BsonDateTime getFecha() {
        return fecha;
    }

    public void setFecha(BsonDateTime fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    

}
