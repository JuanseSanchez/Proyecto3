package com.example.demo.modelo;


public class Consumo {

    private String fecha;
    private Servicio servicio;

    public Consumo(String fecha, Servicio servicio) {
        super();
        this.fecha = fecha;
        this.servicio = servicio;
    }

    public Consumo() {
        super();
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    

}
