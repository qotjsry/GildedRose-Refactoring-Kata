package com.gildedrose.pattern;

import com.gildedrose.domain.Item;

public class NormalItem extends AbstractItemUpdate {

    @Override
    public void update(Item item) {
        updateQuality(item, -1);
    }
}
