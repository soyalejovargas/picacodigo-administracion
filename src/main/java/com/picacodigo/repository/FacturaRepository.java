package com.picacodigo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.picacodigo.model.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Integer>{
	
}
