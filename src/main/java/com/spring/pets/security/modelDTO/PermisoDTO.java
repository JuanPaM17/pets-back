package com.spring.pets.security.modelDTO;

public class PermisoDTO {

	private int id;
	private String nombre;

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

	public PermisoDTO() {
		super();
	}

	public PermisoDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "PermisoDTO [id=" + id + ", nombre=" + nombre + "]";
	}

}
