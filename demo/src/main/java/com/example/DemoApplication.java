package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.entities.Actor;
import com.example.domains.entities.models.ActorDTO;
import com.example.domains.entities.models.ActorShort;
import com.example.domains.services.ActorServiceImpl;
import com.example.ioc.Entorno;
import com.example.ioc.Rango;
import com.example.ioc.Saluda;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import jakarta.transaction.Transactional;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args)  {
		SpringApplication.run(DemoApplication.class, args);
	}

	
	@Autowired
	ActorServiceImpl actorSrv;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada");
		var item = actorSrv.getOne(1);
		if(item.isEmpty()) {
			System.err.println("No encontrado");
		}
		else {
			var actor = item.get();
			System.out.println(item.get());
			actor.getFilmActors().forEach(f -> System.out.println(f.getFilm().getTitle()));
		}
//		actorSrv.deleteById(201);
//		dao.findAll((root, query, builder) -> builder.greaterThanOrEqualTo(root.get("actorId"), 200)).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThan(root.get("actorId"), 10)).forEach(System.out::println);
//		dao.findAll().forEach(i -> System.out.println(ActorDTO.from(i)));
		
//		actorSrv.readByActorIdGreaterThanEqual(190).forEach(f -> System.out.println(f));
//		actorSrv.searchByActorIdGreaterThanEqual(190).forEach(f -> System.out.println(f));
//		actorSrv.queryByActorIdGreaterThanEqual(190, ActorDTO.class).forEach(i -> System.out.println(i));
		actorSrv.getAll(PageRequest.of(3, 10, Sort.by("ActorId"))).forEach(i -> System.out.println(ActorDTO.from(i)));
		var serializa = new XmlMapper();
//		var serializa = new ObjectMapper();
//		actorSrv.queryByActorIdGreaterThanEqual(198, Actor.class).forEach(f -> {
//			try {
//				System.out.println(serializa.writeValueAsString(f));
//			} catch (JsonProcessingException e) {
//				e.printStackTrace();
//			}
//		});
		
//		var actor = new Actor(0, "Pepito", "Grillo");
//		System.out.println(dao.save(actor));
	}

}
