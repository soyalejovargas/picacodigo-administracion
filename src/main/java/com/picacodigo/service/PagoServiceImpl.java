package com.picacodigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picacodigo.model.Pago;
import com.picacodigo.repository.PagoRepository;

@Service
public class PagoServiceImpl implements PagoService {
	
	@Autowired
	private PagoRepository pagoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Pago> findAll() {
		return pagoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Pago> findAll(Pageable paginable) {
		return pagoRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pago> findById(Integer id) {
		return pagoRepository.findById(id);
	}

	@Override
	@Transactional
	public Pago save(Pago conjunto) {
		return pagoRepository.save(conjunto);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		pagoRepository.deleteById(id);
	}

}
