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

import com.picacodigo.model.Persona;
import com.picacodigo.service.PersonaService;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Persona persona){
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Persona> persona = personaService.findById(id);
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(persona);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Persona personaDetalle, @PathVariable Integer id){
		Optional<Persona> persona = personaService.findById(id);
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(personaDetalle, persona.get());
		persona.get().setIdpersona(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(personaService.save(persona.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Persona> persona = personaService.findById(id);
		if(!persona.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		personaService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Persona> readAll(){
		List<Persona> personas = StreamSupport
				.stream(personaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return personas;
	}
}
