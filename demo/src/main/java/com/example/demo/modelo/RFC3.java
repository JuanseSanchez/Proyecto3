package com.example.demo.modelo;

import java.util.List;

public class RFC3 {

    private String hotel;
    private int numero;
    private int totalConsumption;

    public RFC3(String hotel, int numero, int totalConsumption) {
        super();
        this.hotel = hotel;
        this.numero = numero;
        this.totalConsumption = totalConsumption;
    }

    public RFC3() {
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

	public int getTotalConsumption() {
		return totalConsumption;
	}

	public void setTotalConsumption(int totalConsumption) {
		this.totalConsumption = totalConsumption;
	}

	
}
