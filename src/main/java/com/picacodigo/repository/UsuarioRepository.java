package com.picacodigo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.picacodigo.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value = "SELECT * FROM usuario p WHERE p.idusuario = :id", nativeQuery = true)
	public List<Usuario> findAdminById(Integer id);
	
	@Query("SELECT p FROM Usuario p WHERE p.id = :id")
	public List<Usuario> findAdminQueryById(Integer id);
	
}
