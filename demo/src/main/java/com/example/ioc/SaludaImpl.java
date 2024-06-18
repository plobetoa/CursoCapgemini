package com.example.ioc;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SaludaImpl implements Saluda {
	Entorno entorno;
	
	
	public SaludaImpl(Entorno entorno) {
		super();
		this.entorno = entorno;
	}


	@Override
	public void saluda(String nombre) {
		entorno.write("Hola "+ nombre);
	}
	
	@Override
	public int getContador() {
		return entorno.getContador();
	}
}