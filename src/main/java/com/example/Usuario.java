package com.example;


public class Usuario {
	private Long id;
	private String nombre;
	private Integer puntuaje;
	private String resultado;
	public Usuario(String nombre, Integer puntuaje, String resultado) {
		this.nombre = nombre;
		this.puntuaje = puntuaje;
		this.resultado= resultado;
	}
	public Usuario() {
	}
	
	public Usuario(Long id, String nombre, Integer puntuaje, String resultado) {
		
		this.id = id;
		this.nombre = nombre;
		this.puntuaje = puntuaje;
		this.resultado = resultado;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Integer getPuntuaje() {
		return puntuaje;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public void setPuntuaje(Integer puntuaje) {
		this.puntuaje = puntuaje;
	}
}
