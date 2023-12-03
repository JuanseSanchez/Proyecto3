package com.example.demo.modelo;

public class RFC2 {

	private String hotel;
    private int numero;
    private float porcentajeOcupacion;

    public RFC2(String hotel, int numero, float porcentajeOcupacion) {
		super();
		this.hotel = hotel;
		this.numero = numero;
		this.porcentajeOcupacion = porcentajeOcupacion;
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

	public float getPorcentajeOcupacion() {
		return porcentajeOcupacion;
	}

	public void setPorcentajeOcupacion(float porcentajeOcupacion) {
		this.porcentajeOcupacion = porcentajeOcupacion;
	}
}