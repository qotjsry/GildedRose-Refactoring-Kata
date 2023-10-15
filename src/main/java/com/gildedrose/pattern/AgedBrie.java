package com.gildedrose.pattern;

import com.gildedrose.domain.Item;

public class AgedBrie extends AbstractItemUpdate {

    @Override
    public void update(Item item) {
        updateQuality(item,1);
    }
}
