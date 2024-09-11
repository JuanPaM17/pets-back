package com.spring.pets.modelDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MedicamentoDTO {

	private int id;

	@NotEmpty
	@Size(min = 5, message = "Nombre debe tener almenos 5 Caracteres")
	private String nombre;

	@NotEmpty
	@Size(min = 5, message = "Descripcion debe tener almenos 5 Caracteres")
	private String descripcion;

	@NotEmpty
	private int dosis;

	public MedicamentoDTO() {
		super();
	}

	public MedicamentoDTO(int id, String nombre, String descripcion, int dosis) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.dosis = dosis;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", dosis=" + dosis
				+ "]";
	}

}
