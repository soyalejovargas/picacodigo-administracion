package com.picacodigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picacodigo.model.Conjunto;
import com.picacodigo.repository.ConjuntoRepository;

@Service
public class ConjuntoServiceImpl implements ConjuntoService {
	
	@Autowired
	private ConjuntoRepository conjuntoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Conjunto> findAll() {
		return conjuntoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Conjunto> findAll(Pageable paginable) {
		return conjuntoRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Conjunto> findById(Integer id) {
		return conjuntoRepository.findById(id);
	}

	@Override
	@Transactional
	public Conjunto save(Conjunto conjunto) {
		return conjuntoRepository.save(conjunto);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		conjuntoRepository.deleteById(id);
	}

}
