package com.example.demo.modelo;

import java.util.List;

public class EntradaSalida {

    private String fecha;
    private List<Cliente> clientes;

    public EntradaSalida(String fecha, List<Cliente> clientes) {
		this.fecha = fecha;
		this.clientes = clientes;
	}

	public EntradaSalida() {
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