package com.picacodigo.service;

import com.picacodigo.model.Evento;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EventoService {
	public List<Evento> findAll();
	public Page<Evento> findAll(Pageable paginable);
	public Optional<Evento> findById(Integer id);
	public Evento save(Evento evento);
	public void deleteById(Integer id);
	
}
