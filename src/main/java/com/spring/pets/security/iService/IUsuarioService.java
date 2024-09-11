package com.spring.pets.security.iService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.security.model.Usuario;
import com.spring.pets.security.modelDTO.UsuarioDTO;

public interface IUsuarioService {

	UsuarioDTO getById(int id);

	List<UsuarioDTO> getAll(Example<Usuario> example, Pageable pageable);

	JSONArray composeTable(Example<Usuario> example, Pageable pageable);

	Long countAll(Example<Usuario> example);

	UsuarioDTO create(UsuarioDTO object, int rolId);

	void deleteById(int id);

	UsuarioDTO getByUsername(String username);

}
