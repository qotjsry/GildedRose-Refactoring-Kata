package com.gildedrose.pattern;

import com.gildedrose.domain.Item;

public abstract class AbstractItemUpdate implements ItemUpdate {

    public static final int MAX_QUALITY = 50;
    public static final int MIN_QUALITY = 0;

    public void updateQuality(Item item, int amount) {
        if(item.quality + amount < MAX_QUALITY || item.quality + amount > MIN_QUALITY) {
            item.quality += amount;
        }
        item.sellIn -= 1;
    }

}
