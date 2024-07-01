package com.example.aplication.resources;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.domains.contracts.services.ActorService;
import com.example.domains.entities.models.ActorDTO;
import com.example.exceptions.BadRequestException;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

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
	
	@GetMapping("/{id}")
	public ActorDTO getOne(@PathVariable int id) throws NotFoundException{
		var result = srv.getOne(id);
		if(result.isEmpty()) {
			throw new NotFoundException();
		}
		return ActorDTO.from(result.get());
	}
	
	record Peli(int id, String titulo) {}

	@GetMapping(path = "/{id}/pelis")
	@Transactional
	public List<Peli> getPelis(@PathVariable int id) throws NotFoundException{
		var item = srv.getOne(id);
		if(item.isEmpty()) {
			throw new NotFoundException();
		}
		return item.get().getFilmActors().stream().map(o -> new Peli(o.getFilm().getFilmId(), o.getFilm().getTitle())).toList();
	}
	
	@PostMapping
	public ResponseEntity<Object> create(@Valid @RequestBody ActorDTO item) throws DuplicateKeyException, InvalidDataException{
		var newItem= srv.add(ActorDTO.from(item));
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(newItem.getActorId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable int id, @Valid @RequestBody ActorDTO item) throws BadRequestException, NotFoundException, InvalidDataException {
		if(id!= item.getActorId())
			throw new BadRequestException("no coinciden los identificadores");
		srv.modify(ActorDTO.from(item));
	}
	
	
	@DeleteMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable int id) {
		srv.deleteById(id);
	}
	
}
