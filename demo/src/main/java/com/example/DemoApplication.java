package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;
import com.example.ioc.Entorno;
import com.example.ioc.Rango;
import com.example.ioc.Saluda;

import jakarta.transaction.Transactional;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Autowired
	ActorRepository dao;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
		var item = dao.findById(1);
		if(item.isEmpty()) {
			System.err.println("No encontrado");
		}
		else {
			var actor = item.get();
			System.out.println(item.get());
			actor.getFilmActors().forEach(f -> System.out.println(f.getFilm().getTitle()));
		}
		dao.deleteById(201);
		dao.findAll((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("actorId"), 200)).forEach(System.out::println);
		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 10)).forEach(System.out::println);
		
//		var actor = new Actor(0, "Pepito", "Grillo");
//		System.out.println(dao.save(actor));
	}

}
