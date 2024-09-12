package com.spring.pets.IService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.model.Mascota;
import com.spring.pets.modelDTO.MascotaDTO;

public interface IMascotaService {

	MascotaDTO getById(Long id);

	List<MascotaDTO> getAllByClienteId(int id, Pageable pageable);

	MascotaDTO create(MascotaDTO object, String medicamento, String cliente);

	List<MascotaDTO> getAll(Example<Mascota> example, Pageable pageable);

	JSONArray composeTable(Example<Mascota> example, Pageable pageable);

	JSONArray composeTableCliente(int clienteId, Pageable pageable);

	Long countAll(Example<Mascota> example);

	Long countAllByClienteId(int clienteId);

	void deleteById(Long id);

}
