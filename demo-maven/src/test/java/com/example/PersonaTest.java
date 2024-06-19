package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
		}
		@Nested
		class KO{
			
		}
	}
}
