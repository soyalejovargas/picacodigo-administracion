package com.picacodigo.service;

import com.picacodigo.model.Conjunto;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ConjuntoService {
	public List<Conjunto> findAll();
	public Page<Conjunto> findAll(Pageable paginable);
	public Optional<Conjunto> findById(Integer id);
	public Conjunto save(Conjunto conjunto);
	public void deleteById(Integer id);
	
}
