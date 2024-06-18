package com.example.ioc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfig {
	
	@Bean
	int contadorInit() {
		return 0;
		}
	
	@Bean
	@Scope("prototype")
	Entorno entorno(int contadorInit) {
		return new EntornoImpl(contadorInit);
	}

}
