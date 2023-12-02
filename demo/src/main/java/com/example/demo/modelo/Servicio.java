package com.example.demo.modelo;


public class Servicio {

    private String nombre;
    private String fecha;
    private int precio;

    public Servicio(String fecha, int precio){
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    
    

}
