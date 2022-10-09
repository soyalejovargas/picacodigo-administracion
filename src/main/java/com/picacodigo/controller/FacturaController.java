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

import com.picacodigo.model.Factura;
import com.picacodigo.service.FacturaService;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {
	
	@Autowired
	private FacturaService facturaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Factura factura){
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Factura> factura = facturaService.findById(id);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(factura);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Factura facturaDetalle, @PathVariable Integer id){
		Optional<Factura> factura = facturaService.findById(id);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(facturaDetalle, factura.get());
		factura.get().setIdfactura(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaService.save(factura.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Factura> factura = facturaService.findById(id);
		if(!factura.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		facturaService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Factura> readAll(){
		List<Factura> facturas = StreamSupport
				.stream(facturaService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return facturas;
	}
}
