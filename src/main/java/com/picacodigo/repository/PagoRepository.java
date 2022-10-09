package com.picacodigo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.picacodigo.model.Pago;

public interface PagoRepository extends JpaRepository<Pago, Integer>{
	
}
