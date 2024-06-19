package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PersonaTest {

	@Nested
	@DisplayName("Proceso de instanciación")
	class Create{
		@Nested
		class OK{
			@Test
			@DisplayName("Sin apellido")
			void testCreate1(){
				var persona = new Persona(1234,"Juan");
				
				assertNotNull(persona, "No es null");
				assertAll("Persona",
						() -> assertEquals(1234, persona.getId(), "Id correcto"),
						() -> assertEquals("Juan", persona.getNombre(), "Nombre correcto"),
						() -> assertTrue(persona.getApellidos().isEmpty(), "Apellido vacio"));
			}
			
			@Test
			@DisplayName("Con apellido")
			void testCreate2(){
				var persona = new Persona(1234,"Juan","Martinez");
				
				assertNotNull(persona, "No es null");
				assertAll("Persona",
						() -> assertEquals(1234, persona.getId(), "Id correcto"),
						() -> assertEquals("Juan", persona.getNombre(), "Nombre correcto"),
						() -> assertEquals("Martinez", persona.getApellidos().get(), "Apellido correcto"));
			}
			
			@ParameterizedTest(name = "Caso {index}: {0} - {1}")
			@DisplayName("Sin apellido Parametrizado")
			@CsvSource(value = {"1,Juan", "2, Juan Carlos", "3, 'Juan , Miguel'"})
			void testCreate2(int id, String nombre){
				var persona = new Persona(id,nombre);
				
				assertNotNull(persona, "No es null");
				assertAll("Persona",
						() -> assertEquals(id, persona.getId(), "Id correcto"),
						() -> assertEquals(nombre, persona.getNombre(), "Nombre correcto"),
						() -> assertTrue(persona.getApellidos().isEmpty(), "Apellido vacio"));
			}
		}
		@Nested
		class KO{
			@ParameterizedTest(name = "Caso {index}: {0} - {1}")
			@DisplayName("Nombre invalido")
			@CsvSource(value = {"1, ''", "2, '      '", "3, "})
			void testCreate(int id, String nombre){
				assertThrows(IllegalArgumentException.class, () -> new Persona(id,nombre));
			}
		}
	}
}
