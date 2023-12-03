package com.example.demo.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.annotation.Id;

@Document(collection = "reservas")
public class Reserva {
    //_id
    @Id
    private ObjectId id;

    private String inicio;
    private String fin;
    private Habitacion habitacion;

    public Reserva(String inicio, String fin, Habitacion habitacion) {
        super();
        this.inicio = inicio;
        this.fin = fin;
        this.habitacion = habitacion;
    }

    public Reserva() {
        super();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

}
