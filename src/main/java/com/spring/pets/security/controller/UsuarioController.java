package com.spring.pets.security.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.pets.config.BaseController;
import com.spring.pets.security.iService.IUsuarioService;
import com.spring.pets.security.model.Usuario;
import com.spring.pets.security.modelDTO.UsuarioDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth/user")
public class UsuarioController extends BaseController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping
	@PreAuthorize("hasAuthority('READ_USER')")
	public void getAll(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		Example<Usuario> example = null;
		Pageable pageable = null;
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		if (pageParam != null && sizeParam != null) {
			int page = Integer.parseInt(pageParam);
			int size = Integer.parseInt(sizeParam);
			pageable = PageRequest.of(page - 1, size);
		}
		result.put("records", usuarioService.composeTable(example, pageable));
		result.put("totalRecords", usuarioService.countAll(example));
		writeResponse(result, response);
	}

	@PostMapping("/{rol}")
	@PreAuthorize("hasAuthority('CREATE_USER')")
	public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioDTO o,
			@PathVariable(value = "rol", required = false) int rol) {
		return new ResponseEntity<>(usuarioService.create(o, rol), HttpStatus.ACCEPTED);
	}

	@PutMapping("/{rol}")
	@PreAuthorize("hasAuthority('CREATE_USER')")
	public ResponseEntity<UsuarioDTO> update(@RequestBody UsuarioDTO o,
			@PathVariable(value = "rol", required = false) int rol) {
		return new ResponseEntity<>(usuarioService.create(o, rol), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('DELETE_USER')")
	public ResponseEntity<String> delete(@PathVariable(value = "id", required = false) int id) {
		usuarioService.deleteById(id);
		return new ResponseEntity<>("Usuario eliminado con exito", HttpStatus.OK);
	}

}
