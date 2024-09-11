package com.spring.pets.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
import com.spring.pets.security.config.EncrypToData;
import com.spring.pets.security.iService.IUsuarioService;
import com.spring.pets.security.model.Usuario;
import com.spring.pets.security.modelDTO.UsuarioDTO;
import com.spring.pets.security.repository.RolRepository;
import com.spring.pets.security.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private RolRepository rolRepository;

	@Override
	public UsuarioDTO getById(int id) {
		Usuario o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Usuario", "id", String.valueOf(id)));
		return mapDTO(o);
	}

	@Override
	public List<UsuarioDTO> getAll(Example<Usuario> example, Pageable pageable) {
		List<Usuario> lista = new ArrayList<Usuario>();
		if (pageable != null) {
			Page<Usuario> page;
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
	public Long countAll(Example<Usuario> example) {
		if (example != null) {
			return repository.count(example);
		} else {
			return repository.count();
		}
	}

	@Override
	public JSONArray composeTable(Example<Usuario> example, Pageable pageable) {
		JSONArray jsonArray = new JSONArray();
		for (UsuarioDTO usuario : getAll(example, pageable)) {
			JSONObject object = new JSONObject();
			object.put("id", usuario.getId());
			object.put("cedula", usuario.getCedula());
			object.put("nombre", usuario.getNombre());
			object.put("username", usuario.getUsername());
			object.put("contraseña", usuario.getContrasena());
			object.put("rol", usuario.getRolNombre());
			jsonArray.put(object);
		}
		return jsonArray;
	}

	@Override
	public UsuarioDTO create(UsuarioDTO object, int rolId) {
		Usuario o = mapClass(object);
		o.setContrasena(EncrypToData.encryptPassword(object.getContrasena()));
		try {
			o.setRol(rolRepository.findById(rolId)
					.orElseThrow(() -> new ResourceNotFound("Rol", "Id", String.valueOf(rolId))));
			return mapDTO(repository.save(o));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		Usuario o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Usuario", "id", String.valueOf(id)));
		repository.delete(o);
	}

	private Usuario mapClass(UsuarioDTO dto) {
		return modelMapper.map(dto, Usuario.class);
	}

	private UsuarioDTO mapDTO(Usuario object) {
		return modelMapper.map(object, UsuarioDTO.class);
	}

	@Override
	public UsuarioDTO getByUsername(String username) {
		Optional<Usuario> o = repository.findByUsername(username).stream().findFirst();
		return o.isPresent() ? mapDTO(o.get()) : null;
	}

}
