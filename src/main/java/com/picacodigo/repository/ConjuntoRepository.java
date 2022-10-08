package com.picacodigo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.picacodigo.model.Conjunto;

public interface ConjuntoRepository extends JpaRepository<Conjunto, Integer>{
	
}
