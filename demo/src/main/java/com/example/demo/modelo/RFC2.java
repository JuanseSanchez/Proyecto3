package com.example.demo.modelo;

public class RFC2 {

    private int num;
    private float porcentajeOcupacion;

    public RFC2(int num, float porcentajeOcupacion) {
        super();
        this.num = num;
        this.porcentajeOcupacion = porcentajeOcupacion;
    }

    public RFC2() {
        super();
    }

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPorcentajeOcupacion() {
		return porcentajeOcupacion;
	}

	public void setPorcentajeOcupacion(float porcentajeOcupacion) {
		this.porcentajeOcupacion = porcentajeOcupacion;
	}

}