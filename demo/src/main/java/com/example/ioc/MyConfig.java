package com.example.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.event.EventListener;

@Configuration
public class MyConfig {
	
	@Value("${app.contador.init:1}")
	int contInit;
	@Bean
	int contadorInit() {
		return contInit;
		}
	
	@Bean
	@Scope("prototype")
	Entorno entorno(int contadorInit) {
		return new EntornoImpl(contadorInit);
	}
	
	@EventListener
	void trataEvento(SaludaImpl.SaludaEvent evento){
		System.err.println("Evento -> " + evento.tipo() + " -> " + evento.detinatario());
	}

}
