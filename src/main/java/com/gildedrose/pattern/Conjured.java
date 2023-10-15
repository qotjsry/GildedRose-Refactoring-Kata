package com.gildedrose.pattern;

import com.gildedrose.domain.Item;

public class Conjured extends AbstractItemUpdate {

    @Override
    public void update(Item item) {
        updateQuality(item, -2);
    }
}
