package com.gildedrose.pattern;

import com.gildedrose.domain.Item;

public class BackstagePasses implements ItemUpdate {

    @Override
    public void update(Item item) {
        int amount = 0;
        if (item.sellIn > 10) {
            amount = 1;
        } else if (item.sellIn > 5) {
            amount = 2;
        } else if (item.sellIn > 0) {
            amount = 3;
        } else {
            amount = -item.quality;
        }
        updateQuality(item, amount);
    }
}
