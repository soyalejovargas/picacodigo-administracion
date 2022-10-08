package com.picacodigo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.picacodigo.model.Inmueble;

public interface InmuebleRepository extends JpaRepository<Inmueble, Integer>{
	
}
