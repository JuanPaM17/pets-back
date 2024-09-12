package com.spring.pets.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pets.security.config.JwtTokenUtil;
import com.spring.pets.security.iService.IUsuarioService;
import com.spring.pets.security.modelDTO.AuthRequest;
import com.spring.pets.security.modelDTO.UsuarioDTO;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private IUsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
		final String jwt = JwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(jwt);
	}

	@PostMapping("/register/{rol}")
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO o,
			@PathVariable(value = "rol", required = false) int rol) {
		return new ResponseEntity<>(usuarioService.create(o, rol), HttpStatus.ACCEPTED);
	}

}
