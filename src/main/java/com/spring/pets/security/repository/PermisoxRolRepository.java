package com.spring.pets.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.pets.security.model.PermisoxRol;
import com.spring.pets.security.model.PermisoxRolId;

@Repository
public interface PermisoxRolRepository extends JpaRepository<PermisoxRol, PermisoxRolId> {

}
