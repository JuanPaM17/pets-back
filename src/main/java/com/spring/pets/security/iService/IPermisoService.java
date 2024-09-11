package com.spring.pets.security.iService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.security.model.Permiso;
import com.spring.pets.security.modelDTO.PermisoDTO;

public interface IPermisoService {

	PermisoDTO getById(int id);

	List<PermisoDTO> getAll(Example<Permiso> example, Pageable pageable);

	JSONArray composeTable(Example<Permiso> example, Pageable pageable);

	Long countAll(Example<Permiso> example);

	PermisoDTO create(PermisoDTO object);

	void deleteById(int id);

}
