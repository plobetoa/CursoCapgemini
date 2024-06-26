package com.example.domains.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.domains.contracts.repositories.ActorRepository;
import com.example.domains.contracts.repositories.FilmRepository;
import com.example.domains.entities.Actor;
import com.example.domains.entities.Film;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

class FilmServiceImplTest {
	
	FilmServiceImpl srv;
	FilmRepository dao;
	@BeforeEach
	void preparation() {
		dao = mock(FilmRepository.class);
		srv = new FilmServiceImpl(dao);
	}

	@Nested
	@DisplayName("Pruebas de agregar actores")
	class Add{
		@Nested
		class OK{
			@Test
			@DisplayName("Agregar actor correcto")
			void test1(){
				var test = mock(Film.class);
				when(test.isValid()).thenReturn(true);
				try {
					srv.add(test);
				} catch (DuplicateKeyException e) {
					e.printStackTrace();
				} catch (InvalidDataException e) {
					e.printStackTrace();
				}
				verify(dao).save(test);
			}

		}
		@Nested
		class KO{
			@Test
			@DisplayName("Datos incorrectos, el actor no es valido")
			void test1(){
				var test = mock(Film.class);
				when(test.isInvalid()).thenReturn(true);
				assertThrows(InvalidDataException.class, () -> srv.add(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, el actor es null")
			void test2() {
				Film test = null;
				assertThrows(InvalidDataException.class, () -> srv.add(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, ya esta añadido")
			void test3() {
				var test = mock(Film.class);
				when(test.isInvalid()).thenReturn(false);
				when(dao.existsById(anyInt())).thenReturn(true);
				assertThrows(DuplicateKeyException.class, () -> srv.add(test));
			}
			
		}
	}
	
	
	@Nested
	@DisplayName("Pruebas de modificar actores")
	class Modify{
		@Nested
		class OK{
			@Test
			@DisplayName("Agregar actor correcto")
			void test1(){
				var test = mock(Film.class);
				when(test.isValid()).thenReturn(true);
				when(test.getFilmId()).thenReturn(1);
				when(dao.existsById(anyInt())).thenReturn(true);
					try {
						srv.modify(test);
					} catch (NotFoundException e) {
						e.printStackTrace();
					} catch (InvalidDataException e) {
						e.printStackTrace();
					}
				verify(dao).save(test);
			}

		}
		@Nested
		class KO{
			@Test
			@DisplayName("Datos incorrectos, el actor no es valido")
			void test1(){
				var test = mock(Film.class);
				when(test.isInvalid()).thenReturn(true);
				assertThrows(InvalidDataException.class, () -> srv.modify(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, el actor es null")
			void test2() {
				Film test = null;
				assertThrows(InvalidDataException.class, () -> srv.modify(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos,no esta añadido id distito de 0")
			void test3() {
				var test = mock(Film.class);
				when(test.isInvalid()).thenReturn(false);
				when(test.getFilmId()).thenReturn(1);
				when(dao.existsById(anyInt())).thenReturn(false);
				assertThrows(NotFoundException.class, () -> srv.modify(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, no esta añadido id 0")
			void test4() {
				var test = mock(Film.class);
				when(test.isInvalid()).thenReturn(false);
				when(test.getFilmId()).thenReturn(0);
				assertThrows(NotFoundException.class, () -> srv.modify(test));
			}
			
		}
	}
	
	
	@Nested
	@DisplayName("Pruebas de elimirar actores")
	class Delete{
		@Nested
		class OK{
			@Test
			@DisplayName("Eliminar actor correcto")
			void test1(){
				var test = new Film(1);
					try {
						srv.delete(test);
					} catch (InvalidDataException e) {
						e.printStackTrace();
					}
				verify(dao).delete(test);
			}

		}
		@Nested
		class KO{
			@Test
			@DisplayName("Datos incorrectos, el actor es null")
			void test2() {
				Film test = null;
				assertThrows(InvalidDataException.class, () -> srv.delete(test));
			}
			
		}
	}

}
;