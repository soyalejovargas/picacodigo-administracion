package com.picacodigo.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.picacodigo.model.Evento;
import com.picacodigo.service.EventoService;

@RestController
@RequestMapping("/api/eventos")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Evento evento){
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.save(evento));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Evento> evento = eventoService.findById(id);
		if(!evento.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(evento);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Evento eventoDetalle, @PathVariable Integer id){
		Optional<Evento> evento = eventoService.findById(id);
		if(!evento.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(eventoDetalle, evento.get());
		evento.get().setIdevento(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.save(evento.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Evento> evento = eventoService.findById(id);
		if(!evento.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		eventoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Evento> readAll(){
		List<Evento> eventos = StreamSupport
				.stream(eventoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return eventos;
	}
}
