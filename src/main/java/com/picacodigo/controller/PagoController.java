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

import com.picacodigo.model.Pago;
import com.picacodigo.service.PagoService;

@RestController
@RequestMapping("/api/pagos")
public class PagoController {
	
	@Autowired
	private PagoService pagoService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Pago pago){
		return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(pago));
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable Integer id){
		Optional<Pago> pago = pagoService.findById(id);
		if(!pago.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		return ResponseEntity.ok(pago);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Pago pagoDetalle, @PathVariable Integer id){
		Optional<Pago> pago = pagoService.findById(id);
		if(!pago.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		BeanUtils.copyProperties(pagoDetalle, pago.get());
		pago.get().setIdpago(id);
		return ResponseEntity.status(HttpStatus.CREATED).body(pagoService.save(pago.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		Optional<Pago> pago = pagoService.findById(id);
		if(!pago.isPresent()) {
			return ResponseEntity.notFound().build();
		} 
		pagoService.deleteById(id);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Pago> readAll(){
		List<Pago> pagos = StreamSupport
				.stream(pagoService.findAll().spliterator(), false)
				.collect(Collectors.toList());
		return pagos;
	}
}
