package com.example.ioc;

import org.springframework.stereotype.Component;

@Component("saludaEn")
public class SaludaEnImpl implements Saluda {
	Entorno entorno;
	
	
	public SaludaEnImpl(Entorno entorno) {
		super();
		this.entorno = entorno;
	}


	@Override
	public void saluda(String nombre) {
		entorno.write("Hello "+ nombre);
	}
	
	@Override
	public int getContador() {
		return entorno.getContador();
	}
}
