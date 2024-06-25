package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.domains.core.contracts.repositories.RepositoryWithProjections;
import com.example.domains.entities.Actor;
import com.example.domains.entities.models.ActorDTO;
import com.example.domains.entities.models.ActorShort;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor>, RepositoryWithProjections {
	List<Actor> findTop5ByLastNameStartingWithOrderByFirstNameDesc(String prefix);
	List<Actor> findTop5ByLastNameStartingWith(String prefix, Sort oderBy);
	
	List<Actor> findByActorIdGreaterThanEqual(int actorId);
	
	@Query(value= "from Actor a where a.actorId >= ?1")
	List<Actor> findByJPQL(int actorId);
	
	@Query(value= "select * from actor where actor_id >= ?1", nativeQuery = true)
	List<Actor> findBySQL(int id);
	
	List<ActorDTO> searchByActorIdGreaterThanEqual(int actorId);
	List<ActorShort> readByActorIdGreaterThanEqual(int actorId);
	
	<T> List<T> queryByActorIdGreaterThanEqual(int actorId, Class<T> proyeccion);

}
