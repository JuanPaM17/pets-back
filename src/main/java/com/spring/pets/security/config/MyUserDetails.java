package com.spring.pets.security.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.spring.pets.security.iService.IPermisoxRolService;
import com.spring.pets.security.model.Permiso;
import com.spring.pets.security.model.Usuario;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1781651066926945608L;
	private Usuario usuario;
	private IPermisoxRolService permisoxRolService;

	public MyUserDetails(Usuario usuario, IPermisoxRolService permisoxRolService) {
		this.usuario = usuario;
		this.permisoxRolService = permisoxRolService;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		int rolId = usuario.getRol().getId();
		List<String> permisos = getPermissionsByRolId(rolId);
		return permisos.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
	}

	@Override
	public String getPassword() {
		return usuario.getContrasena();
	}

	@Override
	public String getUsername() {
		return usuario.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public List<String> getPermissionsByRolId(int idRol) {
		List<String> permisosMap = new ArrayList<String>();
		List<Permiso> permisosxRole = permisoxRolService.findByRolId(idRol);
		for (Permiso permisos : permisosxRole) {
			permisosMap.add(permisos.getNombre());
		}
		return permisosMap;
	}

}
