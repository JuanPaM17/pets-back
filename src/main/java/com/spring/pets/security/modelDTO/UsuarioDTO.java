package com.spring.pets.security.modelDTO;

public class UsuarioDTO {

	private int id;
	private long cedula;
	private String nombre;
	private String username;
	private String contrasena;
	private String rolNombre;

	public UsuarioDTO() {
		super();
	}

	public UsuarioDTO(int id, long cedula, String nombre, String username, String contrasena, String rolNombre) {
		super();
		this.id = id;
		this.cedula = cedula;
		this.nombre = nombre;
		this.username = username;
		this.contrasena = contrasena;
		this.rolNombre = rolNombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getRolNombre() {
		return rolNombre;
	}

	public void setRolNombre(String rolNombre) {
		this.rolNombre = rolNombre;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", username=" + username
				+ ", contrasena=" + contrasena + ", rol=" + rolNombre + "]";
	}

}
