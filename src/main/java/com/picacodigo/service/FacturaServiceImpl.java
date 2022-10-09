package com.picacodigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picacodigo.model.Factura;
import com.picacodigo.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {
	
	@Autowired
	private FacturaRepository facturaRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Factura> findAll() {
		return facturaRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Factura> findAll(Pageable paginable) {
		return facturaRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Factura> findById(Integer id) {
		return facturaRepository.findById(id);
	}

	@Override
	@Transactional
	public Factura save(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		facturaRepository.deleteById(id);
	}

}
