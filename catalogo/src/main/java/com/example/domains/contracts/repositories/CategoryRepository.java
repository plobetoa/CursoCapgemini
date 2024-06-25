package com.example.domains.contracts.repositories;


import com.example.domains.core.contracts.repositories.ProjectionsAndSpecificationJpaRepository;
import com.example.domains.entities.Film;

public interface CategoryRepository extends ProjectionsAndSpecificationJpaRepository<Film, Integer> {

}
