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

import com.picacodigo.model.Conjunto;
import com.picacodigo.service.ConjuntoService;

@RestController
@RequestMapping("/api/conjuntos")
public class ConjuntoController {
	
	@Autowired
	private ConjuntoService conjuntoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Conjunto conjunto){
		return ResponseEntity.status(HttpStatus.CREATED).body(conjuntoService.save(conjunto));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Conjunto> conjunto = conjuntoService.findById(id);
		if(!conjunto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(conjunto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Conjunto conjuntoDetalle, @PathVariable Integer id){
		Optional<Conjunto> conjunto = conjuntoService.findById(id);
		if(!conjunto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(conjuntoDetalle, conjunto.get());
		conjunto.get().setIdconjunto(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(conjuntoService.save(conjunto.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Conjunto> conjunto = conjuntoService.findById(id);
		if(!conjunto.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		conjuntoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Conjunto> readAll(){
		List<Conjunto> conjuntos = StreamSupport
				.stream(conjuntoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return conjuntos;
	}
}
