package com.spring.pets.IService;

import java.util.List;

import org.json.JSONArray;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;

import com.spring.pets.model.Medicamento;
import com.spring.pets.modelDTO.MedicamentoDTO;

public interface IMedicamentoService {

	MedicamentoDTO getById(int id);

	List<MedicamentoDTO> getAll(Example<Medicamento> example, Pageable pageable);

	List<MedicamentoDTO> getAllByNombre(String search, Pageable pageable);

	JSONArray composeTable(Example<Medicamento> example, Pageable pageable);

	MedicamentoDTO create(MedicamentoDTO object);

	Long countAll(Example<Medicamento> example);

	void deleteById(int id);

}
