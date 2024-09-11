package com.spring.pets.security.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "permiso", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre" }) })
public class Permiso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	public Permiso() {
	}

	public Permiso(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Permiso(int id) {
		super();
		this.id = id;
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
		return "tblpermiso{" + "id=" + id + ", nombre='" + nombre + '\'' + '}';
	}

}
