package com.spring.pets.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pets.model.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {

}
