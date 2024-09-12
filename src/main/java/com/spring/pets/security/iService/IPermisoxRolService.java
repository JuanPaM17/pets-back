package com.spring.pets.security.iService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.security.model.Permiso;
import com.spring.pets.security.model.PermisoxRol;
import com.spring.pets.security.modelDTO.PermisoxRolDTO;

public interface IPermisoxRolService {

	PermisoxRolDTO getById(int permisoId, int rolId);

	List<PermisoxRolDTO> getAll(Example<PermisoxRol> example, Pageable pageable);

	JSONArray composeTable(Example<PermisoxRol> example, Pageable pageable);

	Long countAll(Example<PermisoxRol> example);

	PermisoxRolDTO create(int rolId, int permisoId);

	void deleteById(int permisoId, int rolId);

	List<Permiso> findByRolId(int rolId);

}
