package com.example;

import java.util.List;
import java.util.Optional;

public interface UsuarioDao {
	
	int save(Usuario usuario);
	int update(Usuario usuario);
	int deleteById(Long id);
	int getPuntuajeByName(String nombre);
	List<Usuario> findAll();
	Optional<Usuario> findById(Long id);
}
