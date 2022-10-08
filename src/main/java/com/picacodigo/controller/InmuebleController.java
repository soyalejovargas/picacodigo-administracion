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

import com.picacodigo.model.Inmueble;
import com.picacodigo.service.InmuebleService;

@RestController
@RequestMapping("/api/inmuebles")
public class InmuebleController {
	
	@Autowired
	private InmuebleService inmuebleService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Inmueble inmueble){
		return ResponseEntity.status(HttpStatus.CREATED).body(inmuebleService.save(inmueble));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Inmueble> inmueble = inmuebleService.findById(id);
		if(!inmueble.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(inmueble);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Inmueble inmuebleDetalle, @PathVariable Integer id){
		Optional<Inmueble> inmueble = inmuebleService.findById(id);
		if(!inmueble.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(inmuebleDetalle, inmueble.get());
		inmueble.get().setIdinmueble(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(inmuebleService.save(inmueble.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Inmueble> inmueble = inmuebleService.findById(id);
		if(!inmueble.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		inmuebleService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Inmueble> readAll(){
		List<Inmueble> inmuebles = StreamSupport
				.stream(inmuebleService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return inmuebles;
	}
}
