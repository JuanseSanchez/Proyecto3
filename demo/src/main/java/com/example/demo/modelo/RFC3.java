package com.example.demo.modelo;

public class RFC3 {

    private int totalConsumos;
    private int clienteId;
	private String clienteNombre;

    public RFC3(String clienteNombre, int totalConsumos, int clienteId) {
        super();
        this.clienteNombre = clienteNombre;
        this.totalConsumos = totalConsumos;
        this.clienteId = clienteId;
    }

    public RFC3() {
        super();
    }

	public int getTotalConsumos() {
		return totalConsumos;
	}

	public void setTotalConsumos(int totalConsumos) {
		this.totalConsumos = totalConsumos;
	}

	public int getClienteId() {
		return clienteId;
	}

	public void setClienteId(int clienteId) {
		this.clienteId = clienteId;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

}