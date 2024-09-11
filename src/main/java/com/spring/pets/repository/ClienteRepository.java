package com.spring.pets.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.pets.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	@Query("SELECT c FROM Cliente c WHERE " + "CAST(c.cedula AS string) LIKE %:search%")
	Page<Cliente> findAllByCedula(@Param("search") String search, Pageable pageable);

	Optional<Cliente> findByCedula(Long cedula);

}
