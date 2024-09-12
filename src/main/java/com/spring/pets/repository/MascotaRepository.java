package com.spring.pets.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pets.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

	List<Mascota> findByClienteId(int clienteId);

	Page<Mascota> findByClienteId(int clienteId, Pageable pageable);

	Long countByClienteId(int clienteId);

}
