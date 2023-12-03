package com.example.demo.modelo;

import java.util.List;

public class Habitacion {

	private String hotel;
    private int numero;
	private int diasocupada;
    private TipoHabitacion tipo;
    private List<Cliente> clientes;

    public Habitacion(String hotel, int numero, int diasocupada, TipoHabitacion tipo, List<Cliente> clientes) {
        super();
		this.hotel = hotel;
        this.numero = numero;
		this.diasocupada = diasocupada;
        this.tipo = tipo;
        this.clientes = clientes;
    }

    public Habitacion() {
        super();
    }

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getDiasocupada() {
		return diasocupada;
	}

	public void setDiasocupada(int diasocupada) {
		this.diasocupada = diasocupada;
	}

	public TipoHabitacion getTipo() {
		return tipo;
	}

	public void setTipo(TipoHabitacion tipo) {
		this.tipo = tipo;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
}
