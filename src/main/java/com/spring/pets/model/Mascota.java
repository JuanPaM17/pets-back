package com.spring.pets.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "mascota", uniqueConstraints = @UniqueConstraint(columnNames = { "identificacion" }))
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "identificacion", nullable = false)
	private long identificacion;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "raza", nullable = false)
	private String raza;

	@Column(name = "edad", nullable = false)
	private String edad;

	@Column(name = "peso", nullable = false)
	private long peso;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "medicamento_id", nullable = false)
	private Medicamento medicamento;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente cliente;

	public Mascota() {
		super();
	}

	public Mascota(int id, long identificacion, String nombre, String raza, String edad, long peso,
			Medicamento medicamento, Cliente cliente) {
		super();
		this.id = id;
		this.identificacion = identificacion;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.peso = peso;
		this.medicamento = medicamento;
		this.cliente = cliente;
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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Mascota [id=" + id + ", identificacion=" + identificacion + ", nombre=" + nombre + ", raza=" + raza
				+ ", edad=" + edad + ", peso=" + peso + ", medicamento=" + medicamento + ", cliente=" + cliente + "]";
	}

}
