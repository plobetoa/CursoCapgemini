package com.example.domains.contracts.repositories;


import com.example.domains.core.contracts.repositories.ProjectionsAndSpecificationJpaRepository;
import com.example.domains.entities.FilmCategory;
import com.example.domains.entities.FilmCategoryPK;

public interface FilmCategoryRepository extends ProjectionsAndSpecificationJpaRepository<FilmCategory, FilmCategoryPK> {

}
