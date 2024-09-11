package com.spring.pets.controller;

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

import com.spring.pets.IService.IMascotaService;
import com.spring.pets.config.BaseController;
import com.spring.pets.model.Mascota;
import com.spring.pets.modelDTO.MascotaDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/mascota")
public class MascotaController extends BaseController {

	@Autowired
	private IMascotaService mascotaService;

	@GetMapping
	@PreAuthorize("hasAuthority('READ_PET')")
	public void getAll(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		Example<Mascota> example = null;
		Pageable pageable = null;
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		if (pageParam != null && sizeParam != null) {
			int page = Integer.parseInt(pageParam);
			int size = Integer.parseInt(sizeParam);
			pageable = PageRequest.of(page - 1, size);
		}
		result.put("records", mascotaService.composeTable(example, pageable));
		result.put("totalRecords", mascotaService.countAll(example));
		writeResponse(result, response);
	}

	@PostMapping("/{medicamento}/{cliente}")
	@PreAuthorize("hasAuthority('CREATE_PET')")
	public ResponseEntity<MascotaDTO> create(@RequestBody MascotaDTO o,
			@PathVariable(value = "medicamento", required = false) String medicamento,
			@PathVariable(value = "cliente", required = false) String cliente) {
		return new ResponseEntity<>(mascotaService.create(o, medicamento, cliente), HttpStatus.ACCEPTED);
	}

	@PutMapping("/{medicamento}/{cliente}")
	@PreAuthorize("hasAuthority('CREATE_PET')")
	public ResponseEntity<MascotaDTO> update(@RequestBody MascotaDTO o,
			@PathVariable(value = "medicamento", required = false) String medicamento,
			@PathVariable(value = "cliente", required = false) String cliente) {
		return new ResponseEntity<>(mascotaService.create(o, medicamento, cliente), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('DELETE_PET')")
	public ResponseEntity<String> delete(@PathVariable(value = "id", required = false) long id) {
		mascotaService.deleteById(id);
		return new ResponseEntity<>("Medicamento eliminado con exito", HttpStatus.OK);
	}

}
