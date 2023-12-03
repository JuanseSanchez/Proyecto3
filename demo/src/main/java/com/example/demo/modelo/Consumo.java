package com.example.demo.modelo;


public class Consumo {

    private String fecha;
    private String nombre;
    private int precio;
    private Servicio servicio;

    public Consumo(String fecha, String nombre, int precio, Servicio servicio) {
		super();
        this.fecha = fecha;
		this.nombre = nombre;
		this.precio = precio;
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
		this.precio = precio;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
}
