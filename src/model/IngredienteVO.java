package model;

public class IngredienteVO {

	int idIngrediente;
	String nombre;
	String tipo;

	public IngredienteVO(int idIngrediente, String nombre, String tipo) {
		super();
		this.idIngrediente = idIngrediente;
		this.nombre = nombre;
		this.tipo = tipo;
	}

	public int getIdIngrediente() {
		return idIngrediente;
	}

	public void setIdIngrediente(int idIngrediente) {
		this.idIngrediente = idIngrediente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
