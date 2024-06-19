package com.example;

import java.util.Optional;

public class Persona {
	private int id;
	private String nombre;
	private String apellidos;
	
	
	public Persona(int id, String nombre) {
		super();
		this.id = id;
		setNombre(nombre);
	}
	public Persona(int id, String nombre, String apellidos) {
		this(id,nombre);
		setApellidos(apellidos);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		if(nombre == null) {
			throw new IllegalArgumentException("Falta el nombre");
		}
		this.nombre = nombre;
	}
	public Optional<String> getApellidos() {
		return Optional.ofNullable(apellidos);
	}
	public void setApellidos(String apellidos) {
		if(apellidos == null) {
			throw new IllegalArgumentException("Faltan los apellidos");
		}
		this.apellidos = apellidos;
	}
	
	public void clearApellidos() {
		this.apellidos = null;
	}
	
	
	
}
