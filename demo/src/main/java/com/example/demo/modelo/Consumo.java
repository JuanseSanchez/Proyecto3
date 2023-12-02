package com.example.demo.modelo;

import org.bson.BsonDateTime;

public class Consumo {

    private BsonDateTime fecha;
    private Servicio servicio;

    public Consumo(BsonDateTime fecha, Servicio servicio) {
        super();
        this.fecha = fecha;
        this.servicio = servicio;
    }

    public Consumo() {
        super();
    }

    public BsonDateTime getFecha() {
        return fecha;
    }

    public void setFecha(BsonDateTime fecha) {
        this.fecha = fecha;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    

}
