package com.picacodigo.service;

import com.picacodigo.model.Inmueble;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface InmuebleService {
	public List<Inmueble> findAll();
	public Page<Inmueble> findAll(Pageable paginable);
	public Optional<Inmueble> findById(Integer id);
	public Inmueble save(Inmueble conjunto);
	public void deleteById(Integer id);
	
}
