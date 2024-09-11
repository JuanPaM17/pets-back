package com.spring.pets.security.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class PermisoxRolId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6841450555858747210L;
	private int permiso;
	private int rol;

	public PermisoxRolId() {
		super();
	}

	public PermisoxRolId(int permiso, int rol) {
		super();
		this.permiso = permiso;
		this.rol = rol;
	}

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "PermisoxRolId [permiso=" + permiso + ", rol=" + rol + "]";
	}

}