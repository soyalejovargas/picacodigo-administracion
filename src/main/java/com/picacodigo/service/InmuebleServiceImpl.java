package com.picacodigo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picacodigo.model.Inmueble;
import com.picacodigo.repository.InmuebleRepository;

@Service
public class InmuebleServiceImpl implements InmuebleService {
	
	@Autowired
	private InmuebleRepository inmuebleRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Inmueble> findAll() {
		return inmuebleRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Inmueble> findAll(Pageable paginable) {
		return inmuebleRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Inmueble> findById(Integer id) {
		return inmuebleRepository.findById(id);
	}

	@Override
	@Transactional
	public Inmueble save(Inmueble inmueble) {
		return inmuebleRepository.save(inmueble);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		inmuebleRepository.deleteById(id);
	}

}
