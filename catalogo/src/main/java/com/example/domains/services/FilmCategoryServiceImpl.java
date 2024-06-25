package com.example.domains.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.domains.contracts.repositories.FilmCategoryRepository;
import com.example.domains.contracts.services.FilmCategoryService;
import com.example.domains.entities.FilmCategory;
import com.example.domains.entities.FilmCategoryPK;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

@Service

public class FilmCategoryServiceImpl implements FilmCategoryService {

	private FilmCategoryRepository dao;
	
	
	public FilmCategoryServiceImpl(FilmCategoryRepository dao) {
		this.dao = dao;
	}

	@Override
	public <T> List<T> getByProjection(Class<T> type) {
		return dao.findAllBy(type);
	}

	@Override
	public <T> Iterable<T> getByProjection(Sort sort, Class<T> type) {
		return dao.findAllBy(sort, type);
	}

	@Override
	public <T> Page<T> getByProjection(Pageable pageable, Class<T> type) {
		return dao.findAllBy(pageable, type);
	}

	@Override
	public Iterable<FilmCategory> getAll(Sort sort) {
		return dao.findAll(sort);
	}

	@Override
	public Page<FilmCategory> getAll(Pageable pageable) {
		return dao.findAll(pageable);
	}

	@Override
	public List<FilmCategory> getAll() {
		return dao.findAll();
	}

	@Override
	public Optional<FilmCategory> getOne(FilmCategoryPK id) {
		return dao.findById(id);
	}

	@Override
	public FilmCategory add(FilmCategory item) throws DuplicateKeyException, InvalidDataException {
		if(item == null) {
			throw new InvalidDataException("No puede ser nulo");
		}
		if(item.isInvalid()) {
			throw new InvalidDataException(item.getErrorsMessage(), item.getErrorsFields());
		}
		if(dao.existsById(item.getId())) {
			throw new DuplicateKeyException("Ya existe");
		}
		return dao.save(item);
	}

	@Override
	public FilmCategory modify(FilmCategory item) throws NotFoundException, InvalidDataException {
		if(item == null) {
			throw new InvalidDataException("No puede ser nulo");
		}
		if(item.isInvalid()) {
			throw new InvalidDataException(item.getErrorsMessage(), item.getErrorsFields());
		}
		if(!dao.existsById(item.getId())) {
			throw new NotFoundException("No existe");
		}
		return dao.save(item);
	}

	@Override
	public void delete(FilmCategory item) throws InvalidDataException {
		if(item == null) {
			throw new InvalidDataException("No puede ser nulo");
		}
		dao.delete(item);
		
	}

	@Override
	public void deleteById(FilmCategoryPK id) {
		dao.deleteById(id);
		
	}

}
