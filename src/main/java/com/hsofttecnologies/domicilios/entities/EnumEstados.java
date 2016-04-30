package com.hsofttecnologies.domicilios.entities;

public enum EnumEstados {
	SOLICITADO("Solicitado"), CONFIRMADO("Confirmado"), ENVIADO("Enviado"), RECIBIDO(
			"Recibido");

	private String nombre;

	private EnumEstados(String nombre) {

	}
}
