package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }
    
    @Nested
	@DisplayName("Proceso de actualizar la calidad")
	class UpdateQuality{
		@Nested
		class OK{
			@ParameterizedTest(name = "Caso 1: {0] - {1} - {2} | resultad: {3}")
			@DisplayName("Actualizar la calidad Antes de la fecha de venta")
			@CsvSource(value = {"Manzana, 2, 50, 49"})
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

}
