package com.example.demo.modelo;

public class RFC7 {

    private int id;
    private String nombre;

    public RFC7(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public RFC7() {
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
}
