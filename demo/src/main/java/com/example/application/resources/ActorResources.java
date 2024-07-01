package com.example.application.resources;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.models.ActorDTO;

@RestController
@RequestMapping("/api/actores/v1")
public class ActorResources {
	
	private ActorService srv;

	public ActorResources(ActorService srv) {
		this.srv = srv;
	}
	
	@GetMapping
	public List<ActorDTO> getAll(){
		return srv.getByProjection(ActorDTO.class);
	}

	
}
