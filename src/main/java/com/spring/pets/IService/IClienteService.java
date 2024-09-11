package com.spring.pets.IService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.model.Cliente;
import com.spring.pets.modelDTO.ClienteDTO;

public interface IClienteService {

	ClienteDTO getById(int id);

	ClienteDTO getByCedula(Long cedula);

	List<ClienteDTO> getAllByCedula(String search, Pageable pageable);

	List<ClienteDTO> getAll(Example<Cliente> example, Pageable pageable);

	JSONArray composeTable(Example<Cliente> example, Pageable pageable);

	Long countAll(Example<Cliente> example);

	ClienteDTO create(ClienteDTO object);

	void deleteById(int id);

}
