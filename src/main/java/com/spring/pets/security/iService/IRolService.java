package com.spring.pets.security.iService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.security.model.Rol;
import com.spring.pets.security.modelDTO.RolDTO;

public interface IRolService {

	RolDTO getById(int id);

	RolDTO getByNombre(String nombre);

	List<RolDTO> getAll(Example<Rol> example, Pageable pageable);

	JSONArray composeTable(Example<Rol> example, Pageable pageable);

	Long countAll(Example<Rol> example);

	RolDTO create(RolDTO object);

	void deleteById(int id);

}
