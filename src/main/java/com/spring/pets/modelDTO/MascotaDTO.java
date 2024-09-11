package com.spring.pets.modelDTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class MascotaDTO {

	private int id;

	@NotEmpty
	@Size(min = 5, message = "Identificacion debe tener almenos 5 Caracteres")
	private long identificacion;

	@NotEmpty
	private String nombre;

	@NotEmpty
	private String raza;

	@NotEmpty
	private String edad;

	@NotEmpty
	private long peso;

	private String medicamentoNombre;

	private String clienteNombre;

	public MascotaDTO() {
		super();
	}

	public MascotaDTO(int id,
			@NotEmpty @Size(min = 5, message = "Identificacion debe tener almenos 5 Caracteres") long identificacion,
			@NotEmpty String nombre, @NotEmpty String raza, @NotEmpty String edad, @NotEmpty long peso,
			String medicamentoNombre, String clienteNombre) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.peso = peso;
		this.medicamentoNombre = medicamentoNombre;
		this.clienteNombre = clienteNombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(long identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public long getPeso() {
		return peso;
	}

	public void setPeso(long peso) {
		this.peso = peso;
	}

	public String getMedicamentoNombre() {
		return medicamentoNombre;
	}

	public void setMedicamentoNombre(String medicamentoNombre) {
		this.medicamentoNombre = medicamentoNombre;
	}

	public String getClienteNombre() {
		return clienteNombre;
	}

	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}

	@Override
	public String toString() {
		return "MascotaDTO [id=" + id + ", identificacion=" + identificacion + ", nombre=" + nombre + ", raza=" + raza
				+ ", edad=" + edad + ", peso=" + peso + ", medicamento=" + medicamentoNombre + ", cliente="
				+ clienteNombre + "]";
	}

}
