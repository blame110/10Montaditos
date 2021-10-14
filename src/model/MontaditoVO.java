package model;

import java.io.Serializable;

public class MontaditoVO implements Serializable {

	private int idMontadito;
	private String nombre;
	private int precio;
	private String tamano;
	private short premium;

	public static int SI_PREMIUM = 1;
	public static int NO_PREMIUM = 0;

	public MontaditoVO() {
		super();
		this.idMontadito = 0;
		this.nombre = "";
		this.precio = 0;
		this.tamano = "";
		this.premium = 0;
	}

	public MontaditoVO(int idMontadito, String nombre, int precio, String tamano, short premium) {
		super();
		this.idMontadito = idMontadito;
		this.nombre = nombre;
		this.precio = precio;
		this.tamano = tamano;
		this.premium = premium;
	}

	public int getIdMontadito() {
		return idMontadito;
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

	public String getTamano() {
		return tamano;
	}

	public void setTamano(String tamano) {
		this.tamano = tamano;
	}

	public short getPremium() {
		return premium;
	}

	public void setPremium(short premium) {
		this.premium = premium;
	}

	public void setIdMontadito(int idMontadito) {
		this.idMontadito = idMontadito;
	}

	@Override
	public String toString() {
		return "MontaditoVO [idMontadito=" + idMontadito + ", nombre=" + nombre + ", precio=" + precio + ", tamano="
				+ tamano + ", premium=" + premium + "]";
	}

}
