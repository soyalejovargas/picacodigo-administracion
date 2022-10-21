package com.picacodigo.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.picacodigo.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	@Query(value="SELECT * FROM usuario as u WHERE u.password = :pass AND u.usuario = :user", nativeQuery = true)
	public List<Usuario> loguearse(String pass, String user);
}
