package com.spring.pets.security.modelDTO;

public class RolDTO {

	private int id;
	private String nombre;

	public RolDTO(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public RolDTO() {
		super();
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

	@Override
	public String toString() {
		return "RolDTO [id=" + id + ", nombre=" + nombre + "]";
	}

}
