package com.spring.pets.IService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.model.Mascota;
import com.spring.pets.modelDTO.MascotaDTO;

public interface IMascotaService {

	MascotaDTO getById(Long id);

	MascotaDTO create(MascotaDTO object, String medicamento, String cliente);

	List<MascotaDTO> getAll(Example<Mascota> example, Pageable pageable);

	JSONArray composeTable(Example<Mascota> example, Pageable pageable);

	Long countAll(Example<Mascota> example);

	void deleteById(Long id);

}
