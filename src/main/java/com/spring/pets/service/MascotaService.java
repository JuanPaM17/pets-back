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

import com.spring.pets.IService.IMascotaService;
import com.spring.pets.exeption.ResourceNotFound;
import com.spring.pets.model.Mascota;
import com.spring.pets.modelDTO.MascotaDTO;
import com.spring.pets.repository.ClienteRepository;
import com.spring.pets.repository.MascotaRepository;
import com.spring.pets.repository.MedicamenteRepository;

@Service
public class MascotaService implements IMascotaService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private MascotaRepository repository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private MedicamenteRepository medicamentoRepository;

	@Override
	public MascotaDTO getById(Long id) {
		Mascota o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Medicamento", "id", String.valueOf(id)));
		return mapDTO(o);
	}

	@Override
	public List<MascotaDTO> getAll(Example<Mascota> example, Pageable pageable) {
		List<Mascota> lista = new ArrayList<Mascota>();
		if (pageable != null) {
			Page<Mascota> page;
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
	public JSONArray composeTable(Example<Mascota> example, Pageable pageable) {
		JSONArray jsonArray = new JSONArray();
		for (MascotaDTO usuario : getAll(example, pageable)) {
			JSONObject object = new JSONObject();
			object.put("id", usuario.getId());
			object.put("identificacion", usuario.getIdentificacion());
			object.put("nombre", usuario.getNombre());
			object.put("raza", usuario.getRaza());
			object.put("edad", usuario.getEdad());
			object.put("peso", usuario.getPeso());
			object.put("medicamento", usuario.getMedicamentoNombre());
			object.put("cliente", usuario.getClienteNombre());
			jsonArray.put(object);
		}
		return jsonArray;
	}

	@Override
	public Long countAll(Example<Mascota> example) {
		if (example != null) {
			return repository.count(example);
		} else {
			return repository.count();
		}
	}

	@Override
	public MascotaDTO create(MascotaDTO object, String medicamento, String cliente) {
		Mascota o = mapClass(object);
		try {
			o.setMedicamento(medicamentoRepository.findByNombre(medicamento)
					.orElseThrow(() -> new ResourceNotFound("Medicamento", "Id", String.valueOf(medicamento))));
			o.setCliente(clienteRepository.findByCedula(Long.parseLong(cliente))
					.orElseThrow(() -> new ResourceNotFound("Cliente", "Id", String.valueOf(cliente))));
			return mapDTO(repository.save(o));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void deleteById(Long id) {
		Mascota o = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFound("Medicamento", "id", String.valueOf(id)));
		repository.delete(o);
	}

	private Mascota mapClass(MascotaDTO dto) {
		return modelMapper.map(dto, Mascota.class);
	}

	private MascotaDTO mapDTO(Mascota object) {
		return modelMapper.map(object, MascotaDTO.class);
	}

}
