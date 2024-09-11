package com.spring.pets.security.service;

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

import com.spring.pets.exeption.ResourceNotFound;
import com.spring.pets.security.iService.IRolService;
import com.spring.pets.security.model.Rol;
import com.spring.pets.security.modelDTO.RolDTO;
import com.spring.pets.security.repository.RolRepository;

@Service
public class RolService implements IRolService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private RolRepository repository;

	@Override
	public RolDTO getById(int id) {
		Rol o = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Rol", "id", String.valueOf(id)));
		return mapDTO(o);
	}

	@Override
	public RolDTO getByNombre(String nombre) {
		Rol o = repository.findByNombre(nombre).orElseThrow(() -> new ResourceNotFound("Rol", "nombre", nombre));
		return mapDTO(o);
	}

	@Override
	public List<RolDTO> getAll(Example<Rol> example, Pageable pageable) {
		List<Rol> lista = new ArrayList<Rol>();
		if (pageable != null) {
			Page<Rol> page;
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
	public Long countAll(Example<Rol> example) {
		if (example != null) {
			return repository.count(example);
		} else {
			return repository.count();
		}
	}

	@Override
	public JSONArray composeTable(Example<Rol> example, Pageable pageable) {
		JSONArray jsonArray = new JSONArray();
		for (RolDTO usuario : getAll(example, pageable)) {
			JSONObject object = new JSONObject();
			object.put("id", usuario.getId());
			object.put("nombre", usuario.getNombre());
			jsonArray.put(object);
		}
		return jsonArray;
	}

	@Override
	public RolDTO create(RolDTO object) {
		Rol o = mapClass(object);
		try {
			return mapDTO(repository.save(o));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		Rol o = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Rol", "id", String.valueOf(id)));
		repository.delete(o);
	}

	private Rol mapClass(RolDTO dto) {
		return modelMapper.map(dto, Rol.class);
	}

	private RolDTO mapDTO(Rol object) {
		return modelMapper.map(object, RolDTO.class);
	}

}
