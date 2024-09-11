package com.spring.pets.controller;

import java.util.List;
import java.util.stream.Collectors;

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

import com.spring.pets.IService.IClienteService;
import com.spring.pets.config.BaseController;
import com.spring.pets.model.Cliente;
import com.spring.pets.modelDTO.ClienteDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends BaseController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping
	@PreAuthorize("hasAuthority('READ_BUYER')")
	public void getAll(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		Example<Cliente> example = null;
		Pageable pageable = null;
		String pageParam = request.getParameter("page");
		String sizeParam = request.getParameter("size");
		if (pageParam != null && sizeParam != null) {
			int page = Integer.parseInt(pageParam);
			int size = Integer.parseInt(sizeParam);
			pageable = PageRequest.of(page - 1, size);
		}
		result.put("records", clienteService.composeTable(example, pageable));
		result.put("totalRecords", clienteService.countAll(example));
		writeResponse(result, response);
	}

	@PostMapping
	@PreAuthorize("hasAuthority('CREATE_BUYER')")
	public ResponseEntity<ClienteDTO> create(@RequestBody ClienteDTO o) {
		return new ResponseEntity<>(clienteService.create(o), HttpStatus.ACCEPTED);
	}

	@PutMapping
	@PreAuthorize("hasAuthority('CREATE_BUYER')")
	public ResponseEntity<ClienteDTO> update(@RequestBody ClienteDTO o) {
		return new ResponseEntity<>(clienteService.create(o), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('DELETE_BUYER')")
	public ResponseEntity<String> delete(@PathVariable(value = "id", required = false) int id) {
		clienteService.deleteById(id);
		return new ResponseEntity<>("Cliente eliminado con exito", HttpStatus.OK);
	}

	@GetMapping("/autocomplete")
	@PreAuthorize("hasAuthority('SEARCH_BUYER')")
	public void searchBuyer(HttpServletRequest request, HttpServletResponse response) {
		JSONObject result = new JSONObject();
		String search = request.getParameter("search");
		Pageable pageable = PageRequest.of(1 - 1, 10);
		List<ClienteDTO> clientes = clienteService.getAllByCedula(search, pageable);
		List<String> datosVisibles = clientes.stream().map(ClienteDTO::getCedulaNombreApellido)
				.collect(Collectors.toList());
		List<String> datosOcultos = clientes.stream().map(ClienteDTO::getDatosOcultos).collect(Collectors.toList());
		result.put("data", datosVisibles);
		result.put("hidden", datosOcultos);
		writeResponse(result, response);
	}

}
