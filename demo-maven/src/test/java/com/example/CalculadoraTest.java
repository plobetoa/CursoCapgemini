package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Pruebas de la clase calculadora")
class CalculadoraTest {

	Calculadora calculadora;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calculadora = new Calculadora();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Nested
	@DisplayName("Metodo add")
	class Add {
		@Nested
		class OK {
			@Test
			@DisplayName("Suma dos enteros")
			void testAdd() {
				assertEquals(3, calculadora.add(1, 2));
			}

			@Test
			@DisplayName("Suma dos reales")
			void testAdd2() {

				var result = calculadora.add(1.24, 2.24);

				assertEquals(3.48, result);
			}
		}

		@Nested
		class KO {

		}

	}

	@Nested
	@DisplayName("Metodo div")
	class Div {
		@Nested
		class OK {
			@Test
			@DisplayName("Division de enteros")
			void testDiv() {

				var result = calculadora.div(3, 2);

				assertEquals(1, result);
			}

			@Test
			@DisplayName("Division de reales")
			void testDiv2() {

				var result = calculadora.div(3.0, 2.0);

				assertEquals(1.5, result);
			}
		}

		@Nested
		class KO {
			@Test
			@DisplayName("Division reales por 0")
			void testDiv3() {

				assertThrows(ArithmeticException.class, () -> calculadora.div(3.0, 0.0));
			}
		}
	}

}
