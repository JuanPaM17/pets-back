package com.spring.pets.security.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "permiso_x_rol")
public class PermisoxRol {

	@EmbeddedId
	private PermisoxRolId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("permiso") // Asocia la clave compuesta con el campo "permiso"
	@JoinColumn(name = "permiso_id", nullable = false)
	private Permiso permiso;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("rol") // Asocia la clave compuesta con el campo "rol"
	@JoinColumn(name = "rol_id", nullable = false)
	private Rol rol;

	public PermisoxRol() {
	}

	public PermisoxRol(Rol rol, Permiso permiso) {
		this.id = new PermisoxRolId(permiso.getId(), rol.getId());
		this.permiso = permiso;
		this.rol = rol;
	}

	// Getters y Setters

	public PermisoxRolId getId() {
		return id;
	}

	public void setId(PermisoxRolId id) {
		this.id = id;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
}