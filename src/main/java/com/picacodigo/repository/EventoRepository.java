package com.picacodigo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.picacodigo.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer>{
	
}
