package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ioc.Entorno;
import com.example.ioc.Saluda;
import com.example.ioc.SaludaEnImpl;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	Saluda saludaEs;
	
	@Autowired
	Saluda saludaEn;
	@Autowired
	Entorno entorno;
	
	@Autowired(required = false)
	SaludaEnImpl saluda2;
	
	@Override
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
		
		
		
		saludaEs.saluda("Mundo");
		saludaEs.saluda("Mundo");
		saludaEn.saluda("World");
		
		System.out.println("saludaEs: " +saludaEs.getContador());
		System.out.println("entorno: " +entorno.getContador());
		System.out.println("saludaEn: " + saludaEn.getContador());
		System.out.println("saluda2: " + saluda2.getContador());
	}

}
