package com.picacodigo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.picacodigo.model.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Integer>{
	
	@Query(value = "SELECT * FROM persona p WHERE p.idpersona = :id", nativeQuery = true)
	public List<Persona> findAdminById(Integer id);
	

	@Query("SELECT p FROM Persona p WHERE p.idpersona = :id")
	public List<Persona> findAdminQueryById(Integer id);
}
