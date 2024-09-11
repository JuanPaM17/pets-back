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
import com.spring.pets.security.iService.IRolService;
import com.spring.pets.security.model.Rol;
import com.spring.pets.security.modelDTO.RolDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/auth/rol")
public class RolController extends BaseController {

	@Autowired
	private IRolService rolService;

	@GetMapping
	@PreAuthorize("hasAuthority('READ_ROL')")
	public void getAll(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		Example<Rol> example = null;
		Pageable pageable = null;
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		if (pageParam != null && sizeParam != null) {
			int page = Integer.parseInt(pageParam);
			int size = Integer.parseInt(sizeParam);
			pageable = PageRequest.of(page - 1, size);
		}
		result.put("records", rolService.composeTable(example, pageable));
		result.put("totalRecords", rolService.countAll(example));
		writeResponse(result, response);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('CREATE_ROL')")
	public ResponseEntity<RolDTO> create(@RequestBody RolDTO o) {
		return new ResponseEntity<>(rolService.create(o), HttpStatus.ACCEPTED);
	}

	@PutMapping
	@PreAuthorize("hasAuthority('CREATE_ROL')")
	public ResponseEntity<RolDTO> update(@RequestBody RolDTO o) {
		return new ResponseEntity<>(rolService.create(o), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('DELETE_ROL')")
	public ResponseEntity<String> delete(@PathVariable(value = "id", required = false) int id) {
		rolService.deleteById(id);
		return new ResponseEntity<>("Rol eliminado con exito", HttpStatus.OK);
	}

}
