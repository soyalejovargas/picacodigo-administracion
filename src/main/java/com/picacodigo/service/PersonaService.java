package com.picacodigo.service;

import com.picacodigo.model.Persona;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PersonaService {
	public List<Persona> findAll();
	public Page<Persona> findAll(Pageable paginable);
	public Optional<Persona> findById(Integer id);
	public List<Persona> findAdminById(Integer id);
	public Persona save(Persona persona);
	public void deleteById(Integer id);
	
}
