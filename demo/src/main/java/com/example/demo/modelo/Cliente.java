package com.example.demo.modelo;

import java.util.List;

import org.bson.types.ObjectId;

public class Cliente {

    private ObjectId id;
    private String nombre;
    private String entrada;
    private String salida;
    private List<Consumo> consumo;

    public Cliente(String nombre, String entrada, String salida, List<Consumo> consumo) {
        super();
        this.nombre = nombre;
        this.entrada = entrada;
        this.salida = salida;
        this.consumo = consumo;
    }

    public Cliente() {
        super();
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }

    public String getSalida() {
        return salida;
    }

    public void setSalida(String salida) {
        this.salida = salida;
    }
    
    public List<Consumo> getConsumo() {
        return consumo;
    }

    public void setConsumo(List<Consumo> consumo) {
        this.consumo = consumo;
    }
}
