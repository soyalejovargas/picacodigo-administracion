package com.picacodigo.service;

import com.picacodigo.model.Factura;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FacturaService {
	public List<Factura> findAll();
	public Page<Factura> findAll(Pageable paginable);
	public Optional<Factura> findById(Integer id);
	public Factura save(Factura factura);
	public void deleteById(Integer id);
	
}
