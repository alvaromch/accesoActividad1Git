package actividad1_accesoDatos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Coche implements Serializable {

	private static final long serialVersionUID = -7927988321582695399L;
	private int id;
	private String matricula,marca,modelo,color;
	private List<Coche> listaCoches = new ArrayList();
	
	

	public Coche() {
		super();
	}



	public Coche(int id, String matricula, String marca, String modelo, String color) {
		super();
		this.id = id;
		this.matricula = matricula;
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getMatricula() {
		return matricula;
	}



	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}



	public String getMarca() {
		return marca;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	@Override
	public String toString() {
		return "coche [id=" + id + ", matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color="
				+ color + "]";
	}

	
	public void añadirCoche(Coche coche) {
		listaCoches.add(coche);
	}
	
	
	
}
