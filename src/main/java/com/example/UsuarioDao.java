package com.example;

import java.util.List;

public interface UsuarioDao {
	
	int save(Usuario usuario);
	int update(Usuario usuario);
	int deleteById(Long id);
	List<Usuario> findAll();
}
