package com.spring.pets.security.modelDTO;

public class PermisoxRolDTO {

	private String permisoNombre;
	private String rolNombre;

	public PermisoxRolDTO() {
		super();
	}

	public PermisoxRolDTO(String permisoNombre, String rolNombre) {
		super();
		this.permisoNombre = permisoNombre;
		this.rolNombre = rolNombre;
	}

	public String getPermisoNombre() {
		return permisoNombre;
	}

	public void setPermisoNombre(String permisoNombre) {
		this.permisoNombre = permisoNombre;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	@Override
	public String toString() {
		return "PermisoxRolDTO [permisoNombre=" + permisoNombre + ", rolNombre=" + rolNombre + "]";
	}

}
