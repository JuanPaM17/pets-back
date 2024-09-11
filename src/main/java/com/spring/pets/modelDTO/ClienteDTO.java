package com.spring.pets.modelDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ClienteDTO {

	private int id;

	@NotEmpty
	@Size(min = 10, message = "Cedula debe tener almenos 10 Caracteres")
	private long cedula;

	@NotEmpty
	@Size(min = 5, message = "Nombre debe tener almenos 5 Caracteres")
	private String nombre;

	@NotEmpty
	@Size(min = 5, message = "Apellido debe tener almenos 5 Caracteres")
	private String apellidos;

	@NotEmpty
	@Size(min = 5, message = "Direccion debe tener almenos 5 Caracteres")
	private String direccion;

	@NotEmpty
	private long telefono;

	public ClienteDTO() {
		super();
	}

	public ClienteDTO(int id, long cedula, String nombre, String apellidos, String direccion, long telefono) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getId() {
		return id;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public String getNombreCompleto() {
		return this.nombre + " " + this.apellidos;
	}

	public String getCedulaNombreApellido() {
		return this.cedula + " - " + this.getNombreCompleto();
	}

	public String getDatosOcultos() {
		return String.valueOf(this.cedula);
	}

	@Override
	public String toString() {
		return "ClienteDTO [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", direccion=" + direccion + ", telefono=" + telefono + "]";
	}

}
