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
import com.spring.pets.security.iService.IPermisoService;
import com.spring.pets.security.model.Permiso;
import com.spring.pets.security.modelDTO.PermisoDTO;
import com.spring.pets.security.repository.PermisoRepository;

@Service
public class PermisoService implements IPermisoService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PermisoRepository repository;

	@Override
	public PermisoDTO getById(int id) {
		Permiso o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Permiso", "id", String.valueOf(id)));
		return mapDTO(o);
	}

	@Override
	public List<PermisoDTO> getAll(Example<Permiso> example, Pageable pageable) {
		List<Permiso> lista = new ArrayList<Permiso>();
		if (pageable != null) {
			Page<Permiso> page;
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
	public Long countAll(Example<Permiso> example) {
		if (example != null) {
			return repository.count(example);
		} else {
			return repository.count();
		}
	}

	@Override
	public JSONArray composeTable(Example<Permiso> example, Pageable pageable) {
		JSONArray jsonArray = new JSONArray();
		for (PermisoDTO usuario : getAll(example, pageable)) {
			JSONObject object = new JSONObject();
			object.put("id", usuario.getId());
			object.put("nombre", usuario.getNombre());
			jsonArray.put(object);
		}
		return jsonArray;
	}

	@Override
	public PermisoDTO create(PermisoDTO object) {
		Permiso o = mapClass(object);
		try {
			return mapDTO(repository.save(o));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		Permiso o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Permiso", "id", String.valueOf(id)));
		repository.delete(o);
	}

	private Permiso mapClass(PermisoDTO dto) {
		return modelMapper.map(dto, Permiso.class);
	}

	private PermisoDTO mapDTO(Permiso object) {
		return modelMapper.map(object, PermisoDTO.class);
	}

}
