package com.example.demo.modelo;

import java.util.List;

public class Salida {

    private String fecha;
    private List<Cliente> clientes;

    public Salida(String fecha, List<Cliente> clientes) {
		this.fecha = fecha;
		this.clientes = clientes;
	}

	public Salida() {
        super();
    }

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}