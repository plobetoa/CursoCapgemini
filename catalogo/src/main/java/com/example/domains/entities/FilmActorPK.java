package com.example.domains.entities;

import java.io.Serializable;

import com.example.domains.core.entities.EntityBase;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

/**
 * The primary key class for the film_actor database table.
 * 
 */
@Embeddable
@Schema(name = "Identificador de relación pelicula-actor")
public class FilmActorPK extends EntityBase<FilmActorPK> implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="actor_id", insertable=false, updatable=false, unique=true, nullable=false)
	@Schema(description = "Identificador del actor")
	private int actorId;

	@Column(name="film_id", insertable=false, updatable=false, unique=true, nullable=false)
	@Schema(description = "Identificador de la pelicula")
	private int filmId;

	public FilmActorPK() {
	}
	public FilmActorPK(int filmId, int actorId) {
		this.actorId = actorId;
		this.filmId = filmId;
	}
	public int getActorId() {
		return this.actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	public int getFilmId() {
		return this.filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof FilmActorPK)) {
			return false;
		}
		FilmActorPK castOther = (FilmActorPK)other;
		return 
			(this.actorId == castOther.actorId)
			&& (this.filmId == castOther.filmId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.actorId;
		hash = hash * prime + this.filmId;
		
		return hash;
	}
}