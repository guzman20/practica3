package com.example;


public class Usuario {
	private Long id;
	private String nombre;
	private Integer puntuaje;
	public Usuario(String nombre, Integer puntuaje) {
		this.nombre = nombre;
		this.puntuaje = puntuaje;
	}
	public Usuario() {
	}
	public Usuario(Long id, String nombre, Integer puntuaje) {
		this.id = id;
		this.nombre = nombre;
		this.puntuaje = puntuaje;
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
	public void setPuntuaje(Integer puntuaje) {
		this.puntuaje = puntuaje;
	}
}
