package com.picacodigo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.picacodigo.model.Evento;
import com.picacodigo.repository.EventoRepository;

@Service
public class EventoServiceImpl implements EventoService {
	
	@Autowired
	private EventoRepository eventoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAll() {
		return eventoRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Evento> findAll(Pageable paginable) {
		return eventoRepository.findAll(paginable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Evento> findById(Integer id) {
		return eventoRepository.findById(id);
	}

	@Override
	@Transactional
	public Evento save(Evento evento) {
		return eventoRepository.save(evento);
	}

	@Override
	@Transactional
	public void deleteById(Integer id) {
		eventoRepository.deleteById(id);
	}

}
