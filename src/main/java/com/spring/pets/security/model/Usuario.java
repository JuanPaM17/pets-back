package com.spring.pets.security.model;

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
@Table(name = "usuario", uniqueConstraints = @UniqueConstraint(columnNames = { "cedula", "username" }))
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "cedula", nullable = false)
	private long cedula;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "contrasena", nullable = false)
	private String contrasena;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol rol;

	public Usuario() {
	}

	public Usuario(int id, long cedula, String nombre, String username, String contrasena, Rol rol) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.username = username;
		this.contrasena = contrasena;
		this.rol = rol;
	}

	public Usuario(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public Usuario(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username.trim();
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

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol tipoUsuario) {
		this.rol = tipoUsuario;
	}

	public String getDatosOcultos() {
		return String.valueOf(this.cedula);
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", username=" + username
				+ ", contrasena=" + contrasena + ", rol=" + rol + "]";
	}
}
