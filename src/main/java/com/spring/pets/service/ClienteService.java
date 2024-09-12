package com.spring.pets.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.spring.pets.IService.IClienteService;
import com.spring.pets.exeption.ResourceNotFound;
import com.spring.pets.model.Cliente;
import com.spring.pets.modelDTO.ClienteDTO;
import com.spring.pets.repository.ClienteRepository;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ClienteRepository repository;

	@Override
	public ClienteDTO getById(int id) {
		Cliente o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Cliente", "id", String.valueOf(id)));
		return mapDTO(o);
	}

	@Override
	public ClienteDTO getByCedula(Long cedula) {
		Cliente o = repository.findByCedula(cedula)
				.orElseThrow(() -> new ResourceNotFound("Cliente", "cedula", String.valueOf(cedula)));
		return mapDTO(o);
	}

	@Override
	public List<ClienteDTO> getAllByCedula(String search, Pageable pageable) {
		return repository.findAllByCedula(search, pageable).getContent().stream().map(o -> mapDTO(o))
				.collect(Collectors.toList());
	}

	@Override
	public List<ClienteDTO> getAll(Example<Cliente> example, Pageable pageable) {
		List<Cliente> lista = new ArrayList<Cliente>();
		if (pageable != null) {
			Page<Cliente> page;
			if (example != null) {
				page = repository.findAll(example, pageable);
			} else {
				page = repository.findAll(pageable);
			}
			lista = page.getContent();
		} else {
			if (example != null) {
				lista = repository.findAll(example);
			} else {
				lista = repository.findAll();
			}
		}
		return lista.stream().map(o -> mapDTO(o)).collect(Collectors.toList());
	}

	@Override
	public Long countAll(Example<Cliente> example) {
		if (example != null) {
			return repository.count(example);
		} else {
			return repository.count();
		}
	}

	@Override
	public JSONArray composeTable(Example<Cliente> example, Pageable pageable) {
		JSONArray jsonArray = new JSONArray();
		for (ClienteDTO usuario : getAll(example, pageable)) {
			JSONObject object = new JSONObject();
			object.put("id", usuario.getId());
			object.put("nombre", usuario.getNombre());
			object.put("nombreCompleto", usuario.getNombre() + " " + usuario.getApellidos());
			object.put("apellidos", usuario.getApellidos());
			object.put("cedula", usuario.getCedula());
			object.put("direccion", usuario.getDireccion());
			object.put("telefono", usuario.getTelefono());
			object.put("buttonMoreInformation",
					"<button onclick='loadInformation(" + usuario.getId() + ");' "
							+ "class=\"btn btn-light-primary font-weight-bold mr-2\" "
							+ "type=\"button\" data-toggle=\"modal\" data-target=\"#modal_detail\">\r\n"
							+ "    Detalle\r\n" + "</button>");

			jsonArray.put(object);
		}
		return jsonArray;
	}

	@Override
	public ClienteDTO create(ClienteDTO object) {
		Cliente o = mapClass(object);
		try {
			return mapDTO(repository.save(o));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		Cliente o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Cliente", "id", String.valueOf(id)));
		repository.delete(o);
	}

	private Cliente mapClass(ClienteDTO dto) {
		return modelMapper.map(dto, Cliente.class);
	}

	private ClienteDTO mapDTO(Cliente object) {
		return modelMapper.map(object, ClienteDTO.class);
	}

}
