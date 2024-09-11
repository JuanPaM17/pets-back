package com.spring.pets.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.pets.model.Medicamento;

@Repository
public interface MedicamenteRepository extends JpaRepository<Medicamento, Integer> {

	@Query("SELECT m FROM Medicamento m WHERE " + "m.nombre LIKE %:search%")
	Page<Medicamento> findAllByNombre(@Param("search") String search, Pageable pageable);

	Optional<Medicamento> findByNombre(String nombre);

}
