package com.picacodigo.service;

import com.picacodigo.model.Usuario;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {
	public List<Usuario> findAll();
	public Page<Usuario> findAll(Pageable paginable);
	public Optional<Usuario> findById(Integer id);
	public Usuario save(Usuario usuario);
	public void deleteById(Integer id);
	public List<Usuario> verificacionUsuario(String pass, String user);
}
