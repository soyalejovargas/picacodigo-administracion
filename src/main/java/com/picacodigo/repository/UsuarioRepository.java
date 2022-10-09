package com.picacodigo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.picacodigo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
}
