package com.example.demo.modelo;

import java.util.List;

import org.bson.BsonDateTime;

public class Cliente {

    private int id;
    private String nombre;
    private BsonDateTime entrada;
    private BsonDateTime salida;
    private List<Consumo> consumo;

    public Cliente(String nombre, BsonDateTime entrada, BsonDateTime salida, List<Consumo> consumo) {
        super();
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
        this.consumo = consumo;
    }

    public Cliente() {
        super();
    }

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

    public BsonDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(BsonDateTime entrada) {
        this.entrada = entrada;
    }

    public BsonDateTime getSalida() {
        return salida;
    }

    public void setSalida(BsonDateTime salida) {
        this.salida = salida;
    }
    
    public List<Consumo> getConsumo() {
        return consumo;
    }

    public void setConsumo(List<Consumo> consumo) {
        this.consumo = consumo;
    }
}
