package com.spring.pets.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pets.security.model.Permiso;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Integer> {

}
