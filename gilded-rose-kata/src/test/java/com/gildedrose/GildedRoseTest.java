package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
			@CsvSource(value = {"Manzana, 2, 50, 49", "Manzana, 0, 50, 48", "Manzana, 0, 0, 0", "Manzana, 2, 0, 0"})
			void testUpdate1(String name, int sellIn, int quality, int result){
				Item item = new Item(name, sellIn, quality);
				Item[] items = {item};
				GildedRose gilded = new GildedRose(items);
				gilded.updateQuality();
				assertEquals(result, gilded.items[0].quality);
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
  			@CsvSource(value = {"Conjurado Manzana, 2, 50, 48", "Conjurado Manzana, 0, 50, 46", "Conjurado Manzana, 0, 0, 0", "ConjuradoManzana, 2, 0, 0"})
  			void testUpdate1(String name, int sellIn, int quality, int result){
  				Item item = new Item(name, sellIn, quality);
  				Item[] items = {item};
  				GildedRose gilded = new GildedRose(items);
  				gilded.updateQuality();
  				assertEquals(result, gilded.items[0].quality);
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
   			@CsvSource(value = {"Aged Brie, 2, 42, 43", "Aged Brie, 0, 46, 48", "Aged Brie, 0, 50, 50", "Aged Brie, 2, 50, 50"})
   			void testUpdate1(String name, int sellIn, int quality, int result){
   				Item item = new Item(name, sellIn, quality);
   				Item[] items = {item};
   				GildedRose gilded = new GildedRose(items);
   				gilded.updateQuality();
   				assertEquals(result, gilded.items[0].quality);
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
   			@CsvSource(value = {"Backstage passes to a TAFKAL80ETC concert, 11, 42, 43", "Backstage passes to a TAFKAL80ETC concert, 10, 46, 48",
   					"Backstage passes to a TAFKAL80ETC concert, 6, 42, 44", "Backstage passes to a TAFKAL80ETC concert, 5, 46, 49",
   					"Backstage passes to a TAFKAL80ETC concert, 1, 42, 45", "Backstage passes to a TAFKAL80ETC concert, 0, 46, 0"})
   			void testUpdate2(String name, int sellIn, int quality, int result){
   				Item item = new Item(name, sellIn, quality);
   				Item[] items = {item};
   				GildedRose gilded = new GildedRose(items);
   				gilded.updateQuality();
   				assertEquals(result, gilded.items[0].quality);
   			}

   		}
   		@Nested
   		class KO{
   			
   			
   		}
   	}

}
