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
import com.spring.pets.security.iService.IPermisoxRolService;
import com.spring.pets.security.model.Permiso;
import com.spring.pets.security.model.PermisoxRol;
import com.spring.pets.security.model.PermisoxRolId;
import com.spring.pets.security.modelDTO.PermisoxRolDTO;
import com.spring.pets.security.repository.PermisoxRolRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class PermisoxRolService implements IPermisoxRolService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private PermisoxRolRepository repository;

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public PermisoxRolDTO getById(int permisoId, int rolId) {
		PermisoxRolId primaryKey = new PermisoxRolId(permisoId, rolId);
		PermisoxRol o = repository.findById(primaryKey)
				.orElseThrow(() -> new ResourceNotFound("PermisoxRol", "id", primaryKey.toString()));
		return mapDTO(o);
	}

	@Override
	public List<PermisoxRolDTO> getAll(Example<PermisoxRol> example, Pageable pageable) {
		List<PermisoxRol> lista = new ArrayList<PermisoxRol>();
		if (pageable != null) {
			Page<PermisoxRol> page;
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
	public Long countAll(Example<PermisoxRol> example) {
		if (example != null) {
			return repository.count(example);
		} else {
			return repository.count();
		}
	}

	@Override
	public JSONArray composeTable(Example<PermisoxRol> example, Pageable pageable) {
		JSONArray jsonArray = new JSONArray();
		for (PermisoxRolDTO usuario : getAll(example, pageable)) {
			JSONObject object = new JSONObject();
			object.put("permiso", usuario.getPermisoNombre());
			object.put("Rol", usuario.getRolNombre());
			jsonArray.put(object);
		}
		return jsonArray;
	}

	@Override
	public PermisoxRolDTO create(PermisoxRolDTO object) {
		PermisoxRol o = mapClass(object);
		try {
			return mapDTO(repository.save(o));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(int permisoId, int rolId) {
		PermisoxRolId primaryKey = new PermisoxRolId(permisoId, rolId);
		PermisoxRol o = repository.findById(primaryKey)
				.orElseThrow(() -> new ResourceNotFound("PermisoxRol", "id", primaryKey.toString()));
		repository.delete(o);
	}

	@Override
	public List<Permiso> findByRolId(int rolId) {
		return entityManager
				.createQuery("SELECT pr.permiso FROM PermisoxRol pr " + "WHERE pr.rol.id = :rolId", Permiso.class)
				.setParameter("rolId", rolId).getResultList();
	}

	private PermisoxRol mapClass(PermisoxRolDTO dto) {
		return modelMapper.map(dto, PermisoxRol.class);
	}

	private PermisoxRolDTO mapDTO(PermisoxRol object) {
		return modelMapper.map(object, PermisoxRolDTO.class);
	}

}
