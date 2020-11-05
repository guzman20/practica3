package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioJdbc implements UsuarioDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int save(Usuario usuario) {
		return jdbcTemplate.update("insert into usuarios (nombre, puntuaje) values(?,?)", usuario.getNombre(), usuario.getPuntuaje());
	}

	@Override
	public int update(Usuario usuario) {
		return jdbcTemplate.update("update usuarios set puntuaje = ? where id = ?", usuario.getPuntuaje(), usuario.getId());
	}

	@Override
	public int deleteById(Long id) {
		return jdbcTemplate.update("delete from usuarios where id = ?", id);
	}

	@Override
	public List<Usuario> findAll() {
		return jdbcTemplate.query("select * from usuarios",
				(rs, rowNum) -> new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getInt("puntuaje")));
	}

	@Override
	public Optional<Usuario> findById(Long id) {
		return jdbcTemplate.queryForObject("select * from usuarios where id = ?", new Object[] { id }, (rs,
				rowNum) -> Optional.of(new Usuario(rs.getLong("id"), rs.getString("nombre"), rs.getInt("puntuaje"))));
	}

	@Override
	public int getPuntuajeByName(String nombre) {
		// TODO Auto-generated method stub
		return 0;
	}
}
