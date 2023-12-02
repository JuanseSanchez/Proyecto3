package com.example.demo.modelo;

import org.bson.BsonDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "reservas")
public class Reserva {
    //_id
    @Id
    private int id;

    private BsonDateTime fechaInicio;
    private BsonDateTime fechaFin;
    private Habitacion habitacion;

    public Reserva(BsonDateTime fechaInicio, BsonDateTime fechaFin, Habitacion habitacion) {
        super();
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.habitacion = habitacion;
        
    }

    public Reserva() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BsonDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(BsonDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public BsonDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(BsonDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    
    
    
}
