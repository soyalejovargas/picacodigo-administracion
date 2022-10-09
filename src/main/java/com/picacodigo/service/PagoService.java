package com.picacodigo.service;

import com.picacodigo.model.Pago;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PagoService {
	public List<Pago> findAll();
	public Page<Pago> findAll(Pageable paginable);
	public Optional<Pago> findById(Integer id);
	public Pago save(Pago pago);
	public void deleteById(Integer id);
	
}
