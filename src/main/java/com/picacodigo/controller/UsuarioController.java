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

import com.picacodigo.model.Usuario;
import com.picacodigo.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Usuario> usuario = usuarioService.findById(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(usuario);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioDetalle, @PathVariable Integer id){
		Optional<Usuario> usuario = usuarioService.findById(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(usuarioDetalle, usuario.get());
		usuario.get().setIdusuario(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.save(usuario.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Usuario> usuario = usuarioService.findById(id);
		if(!usuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		usuarioService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Usuario> readAll(){
		List<Usuario> usuarios = StreamSupport
				.stream(usuarioService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return usuarios;
	}
}
