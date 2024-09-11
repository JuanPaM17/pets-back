package com.spring.pets.service;

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

import com.spring.pets.IService.IMedicamentoService;
import com.spring.pets.exeption.ResourceNotFound;
import com.spring.pets.model.Medicamento;
import com.spring.pets.modelDTO.MedicamentoDTO;
import com.spring.pets.repository.MedicamenteRepository;

@Service
public class MedicamentoService implements IMedicamentoService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MedicamenteRepository repository;

	@Override
	public MedicamentoDTO getById(int id) {
		Medicamento o = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Medicamento", "id", String.valueOf(id)));
		return mapDTO(o);
	}

	@Override
	public List<MedicamentoDTO> getAllByNombre(String search, Pageable pageable) {
		return repository.findAllByNombre(search, pageable).getContent().stream().map(o -> mapDTO(o))
				.collect(Collectors.toList());
	}

	@Override
	public Long countAll(Example<Medicamento> example) {
		if (example != null) {
			return repository.count(example);
		} else {
			return repository.count();
		}
	}

	@Override
	public List<MedicamentoDTO> getAll(Example<Medicamento> example, Pageable pageable) {
		List<Medicamento> lista = new ArrayList<Medicamento>();
		if (pageable != null) {
			Page<Medicamento> page;
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
	public JSONArray composeTable(Example<Medicamento> example, Pageable pageable) {
		JSONArray jsonArray = new JSONArray();
		for (MedicamentoDTO usuario : getAll(example, pageable)) {
			JSONObject object = new JSONObject();
			object.put("id", usuario.getId());
			object.put("nombre", usuario.getNombre());
			object.put("descripcion", usuario.getDescripcion());
			object.put("dosis", usuario.getDosis());
			jsonArray.put(object);
		}
		return jsonArray;
	}

	@Override
	public MedicamentoDTO create(MedicamentoDTO object) {
		Medicamento o = mapClass(object);
		try {
			return mapDTO(repository.save(o));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(int id) {
		Medicamento o = repository.findById(id).orElseThrow(() -> new ResourceNotFound("Medicamento", "id", String.valueOf(id)));
		repository.delete(o);
	}

	private Medicamento mapClass(MedicamentoDTO dto) {
		return modelMapper.map(dto, Medicamento.class);
	}

	private MedicamentoDTO mapDTO(Medicamento object) {
		return modelMapper.map(object, MedicamentoDTO.class);
	}

}
