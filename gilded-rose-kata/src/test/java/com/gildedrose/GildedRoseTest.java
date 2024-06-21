package com.gildedrose;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

class GildedRoseTest {
    
    @Nested
	@DisplayName("Proceso de actualizar la calidad de productos normales")
	class ProductosNormales{
		@Nested
		class OK{
			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2} | resultad: {3}")
			@DisplayName("Actualizar la calidad")
			@CsvSource(value = {"Manzana, 2, 50, 49, 1", "Manzana, 0, 50, 48, -1", "Manzana, 0, 0, 0, -1", "Manzana, 2, 0, 0, 1"})
			/**
			 * Caso 1: quedan dias y queda calidad
			 * Caso 2: no quedan dias y queda calidad
			 * Caso 3: no quedan dias y queda calidad
			 * Caso 4: quedan dias y no queda calidad
			 * @param name nombre del producto
			 * @param sellIn dias que le quedan al producto
			 * @param quality calidad del producto
			 * @param result resultado esperado de la calidad
			 */
			void testUpdate1(String name, int sellIn, int quality, int result, int result2){
				Item item = new Item(name, sellIn, quality);
				Item[] items = {item};
				GildedRose gilded = new GildedRose(items);
				gilded.updateQuality();
				assertAll("NormalItem",
					() -> assertEquals(name, gilded.items[0].name),
					() -> assertEquals(result, gilded.items[0].quality),
					() -> assertEquals(result2, gilded.items[0].sellIn));
			}

		}
		@Nested
		class KO{
			
			
		}
	}
    
    @Nested
  	@DisplayName("Proceso de actualizar la calidad de productos conjurados")
  	class ProductosConjurados{
  		@Nested
  		class OK{
  			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2} | resultad: {3}")
  			@DisplayName("Actualizar la calidad")
  			@CsvSource(value = {"Conjured Manzana, 2, 50, 48, 1", "Conjured Manzana, 0, 50, 46, -1", "Conjured Manzana, 0, 0, 0, -1", "Conjured Manzana, 2, 0, 0, 1"})
  			/**
			 * Caso 1: quedan dias y queda calidad
			 * Caso 2: no quedan dias y queda calidad
			 * Caso 3: no quedan dias y queda calidad
			 * Caso 4: quedan dias y no queda calidad
			 * @param name nombre del producto
			 * @param sellIn dias que le quedan al producto
			 * @param quality calidad del producto
			 * @param result resultado esperado de la calidad
			 */
  			void testUpdate1(String name, int sellIn, int quality, int result, int result2){
  				Item item = new Item(name, sellIn, quality);
  				Item[] items = {item};
  				GildedRose gilded = new GildedRose(items);
  				gilded.updateQuality();
  				assertAll("NormalItem",
  						() -> assertEquals(name, gilded.items[0].name),
  						() -> assertEquals(result, gilded.items[0].quality),
  						() -> assertEquals(result2, gilded.items[0].sellIn));
  				}
  			}
  		@Nested
  		class KO{
  			
  			
  		}
  	}
    
    @Nested
   	@DisplayName("Proceso de actualizar la calidad de queso brie")
   	class Queso{
   		@Nested
   		class OK{
   			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2} | resultad: {3}")
   			@DisplayName("Actualizar la calidad")
   			@CsvSource(value = {"Aged Brie, 2, 42, 43, 1", "Aged Brie, 0, 46, 48, -1", "Aged Brie, 0, 50, 50, -1", "Aged Brie, 2, 50, 50, 1"})
   			/**
			 * Caso 1: quedan dias y queda calidad
			 * Caso 2: no quedan dias y queda calidad
			 * Caso 3: no quedan dias y queda calidad
			 * Caso 4: quedan dias y no queda calidad
			 * @param name nombre del producto
			 * @param sellIn dias que le quedan al producto
			 * @param quality calidad del producto
			 * @param result resultado esperado de la calidad
			 */
   			void testUpdate1(String name, int sellIn, int quality, int result, int result2){
   				Item item = new Item(name, sellIn, quality);
   				Item[] items = {item};
   				GildedRose gilded = new GildedRose(items);
   				gilded.updateQuality();
   				assertAll("NormalItem",
   						() -> assertEquals(name, gilded.items[0].name),
   						() -> assertEquals(result, gilded.items[0].quality),
   						() -> assertEquals(result2, gilded.items[0].sellIn));
   			}
   			

   			}
   		@Nested
   		class KO{
   			
   			
   		}
   	}
    
    @Nested
   	@DisplayName("Proceso de actualizar la calidad de Sulfuras")
   	class Sulfuras{
   		@Nested
   		class OK{
   			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2} | resultad: {3}")
   			@DisplayName("Actualizar la calidad")
   			@CsvSource(value = {"'Sulfuras, Hand of Ragnaros', 2, 42, 42", "'Sulfuras, Hand of Ragnaros', 3, 46, 46"})
   			/**
			 * @param name nombre del producto
			 * @param sellIn dias que le quedan al producto
			 * @param quality calidad del producto
			 * @param result resultado esperado de la calidad
			 */
   			void testUpdate1(String name, int sellIn, int quality, int result){
   				Item item = new Item(name, sellIn, quality);
   				Item[] items = {item};
   				GildedRose gilded = new GildedRose(items);
   				gilded.updateQuality();
   				assertEquals(result, gilded.items[0].quality);
   			}
   			
   			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2} | resultad: {3}")
   			@DisplayName("Actualizar la fecha")
   			@CsvSource(value = {"'Sulfuras, Hand of Ragnaros', 2, 42, 2", "'Sulfuras, Hand of Ragnaros', 3, 46, 3"})
   			/**
			 * @param name nombre del producto
			 * @param sellIn dias que le quedan al producto
			 * @param quality calidad del producto
			 * @param result resultado esperado de los dias
			 */
   			void testUpdate2(String name, int sellIn, int quality, int result){
   				Item item = new Item(name, sellIn, quality);
   				Item[] items = {item};
   				GildedRose gilded = new GildedRose(items);
   				gilded.updateQuality();
   				assertEquals(result, gilded.items[0].sellIn);
   			}

   		}
   		@Nested
   		class KO{
   			
   			
   		}
   	}
    
    @Nested
   	@DisplayName("Proceso de actualizar la calidad de las entradas")
   	class Entradas{
   		@Nested
   		class OK{
   			
   			@ParameterizedTest(name = "Caso {index}: {0} - {1} - {2} | resultad: {3}")
   			@DisplayName("Actualizar la fecha")
   			@CsvSource(value = {"Backstage passes to a TAFKAL80ETC concert, 11, 42, 43, 10", "Backstage passes to a TAFKAL80ETC concert, 10, 46, 48, 9",
   					"Backstage passes to a TAFKAL80ETC concert, 6, 42, 44, 5", "Backstage passes to a TAFKAL80ETC concert, 5, 46, 49, 4",
   					"Backstage passes to a TAFKAL80ETC concert, 1, 42, 45, 0", "Backstage passes to a TAFKAL80ETC concert, 0, 46, 0, -1"})
   			/**
			 * Caso 1: Mas de 10 dias restantes
			 * Caso 2: 10 dias restantes
			 * Caso 3: 6 dias restantes
			 * Caso 4: 5 dias restantes
			 * Caso 5: 1 dias restantes
			 * Caso 6: 0 dias restantes
			 * @param name nombre del producto
			 * @param sellIn dias que le quedan al producto
			 * @param quality calidad del producto
			 * @param result resultado esperado de la calidad
			 */
   			void testUpdate2(String name, int sellIn, int quality, int result, int result2){
   				Item item = new Item(name, sellIn, quality);
   				Item[] items = {item};
   				GildedRose gilded = new GildedRose(items);
   				gilded.updateQuality();
   				assertAll("NormalItem",
   						() -> assertEquals(name, gilded.items[0].name),
   						() -> assertEquals(result, gilded.items[0].quality),
   						() -> assertEquals(result2, gilded.items[0].sellIn));
   			}

   		}
   		@Nested
   		class KO{
   			
   			
   		}
   	}

}
