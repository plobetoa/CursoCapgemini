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
import com.example.domains.entities.Actor;
import com.example.exceptions.DuplicateKeyException;
import com.example.exceptions.InvalidDataException;
import com.example.exceptions.NotFoundException;

class ActorServiceImplTest {
	
	ActorServiceImpl srv;
	ActorRepository dao;
	@BeforeEach
	void preparation() {
		dao = mock(ActorRepository.class);
		srv = new ActorServiceImpl(dao);
	}

	@Nested
	@DisplayName("Pruebas de agregar actores")
	class Add{
		@Nested
		class OK{
			@Test
			@DisplayName("Agregar actor correcto")
			void test1(){
				var test = new Actor(0,"Juan","Carlos");
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
			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2}")
			@DisplayName("Datos incorrectos, el actor no es valido")
			@CsvSource(value = {"1, ,Carlos","1,Carlos, ", "1,'',Carlos","1,carlos,''", 
					"1, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, Carlos", 
					"1, Carlos, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
					"1, a, Carlos", "1, Carlos, a", "1,'     ',Carlos", "1, Carlos, '      '"})
			void test1(int id, String name, String surname){
				var test = new Actor(id,name,surname);
				assertThrows(InvalidDataException.class, () -> srv.add(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, el actor es null")
			void test2() {
				Actor test = null;
				assertThrows(InvalidDataException.class, () -> srv.add(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, ya esta añadido")
			void test3() {
				var test = new Actor(1,"Juan","Carlos");
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
				var test = new Actor(1,"Juan","Carlos");
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
			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2}")
			@DisplayName("Datos incorrectos, el actor no es valido")
			@CsvSource(value = {"1, ,Carlos","1,Carlos, ", "1,'',Carlos","1,carlos,''", 
					"1, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa, Carlos", 
					"1, Carlos, aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
					"1, a, Carlos", "1, Carlos, a", "1,'     ',Carlos", "1, Carlos, '      '"})
			void test1(int id, String name, String surname){
				var test = new Actor(id,name,surname);
				assertThrows(InvalidDataException.class, () -> srv.modify(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, el actor es null")
			void test2() {
				Actor test = null;
				assertThrows(InvalidDataException.class, () -> srv.modify(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos,no esta añadido id distito de 0")
			void test3() {
				var test = new Actor(1,"Juan","Carlos");
				when(dao.existsById(anyInt())).thenReturn(false);
				assertThrows(NotFoundException.class, () -> srv.modify(test));
			}
			
			@Test
			@DisplayName("Datos incorrectos, no esta añadido id 0")
			void test4() {
				var test = new Actor(0,"Juan","Carlos");
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
				var test = new Actor(1,"Juan","Carlos");
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
				Actor test = null;
				assertThrows(InvalidDataException.class, () -> srv.delete(test));
			}
			
		}
	}

}
;