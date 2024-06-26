package com.example.domains.contracts.services;

import com.example.domains.core.contracts.services.ProjectionDomainService;
import com.example.domains.entities.Actor;
import com.example.domains.entities.Category;
import com.example.domains.entities.Film;
import com.example.exceptions.InvalidDataException;

public interface FilmService extends ProjectionDomainService<Film, Integer>{

}
