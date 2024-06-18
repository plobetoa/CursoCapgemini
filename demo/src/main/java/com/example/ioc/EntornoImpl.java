package com.example.ioc;


public class EntornoImpl implements Entorno {
	private int contador;
	
	public EntornoImpl(int contador) {
		super();
		this.contador = contador;
	}

	@Override
	public void write(String cad) {
		contador ++;
		System.out.println(cad);
	}

	@Override
	public int getContador() {
		return contador;
	}
	
	

}
