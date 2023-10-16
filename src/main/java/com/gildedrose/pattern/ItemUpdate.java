package com.gildedrose.pattern;

import com.gildedrose.domain.Item;

import static com.gildedrose.pattern.VaildItemUpdate.MAX_QUALITY;
import static com.gildedrose.pattern.VaildItemUpdate.MIN_QUALITY;

public interface ItemUpdate {

    void update(Item item);

    default void updateQuality(Item item, int amount) {
        if(item.quality + amount < MAX_QUALITY || item.quality + amount > MIN_QUALITY) {
            item.quality += amount;
        }
        item.sellIn -= 1;
    }
}
