package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItemQuality(item);
            updateItemSellIn(item);
            handleExpiredItem(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isSpecialItem(item)) {
            updateSpecialItemQuality(item);
        } else {
            updateNormalItemQuality(item);
        }
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals("Aged Brie")
                || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItemQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (item.sellIn < 11 && item.quality < 50) {
                    item.quality++;
                }
                if (item.sellIn < 6 && item.quality < 50) {
                    item.quality++;
                }
            }
        }
    }

    private void updateNormalItemQuality(Item item) {
        if (item.name.startsWith("Conjured")) {
            updateConjuredItemQuality(item);
        } else {
            updateRegularItemQuality(item);
        }
    }

    private void updateConjuredItemQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 2;
        }
    }

    private void updateRegularItemQuality(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality--;
        }
    }

    private void updateItemSellIn(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.sellIn >= 0) {
            return;
        }

        if (isSpecialItem(item)) {
            handleExpiredSpecialItem(item);
        } else {
            handleExpiredNormalItem(item);
        }
    }

    private void handleExpiredSpecialItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            if (item.quality < 50) {
                item.quality++;
            }
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        }
    }

    private void handleExpiredNormalItem(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            if (item.name.startsWith("Conjured")) {
                updateConjuredItemQuality(item);
            } else {
                updateRegularItemQuality(item);
            }
        }
    }
}

