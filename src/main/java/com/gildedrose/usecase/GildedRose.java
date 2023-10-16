package com.gildedrose.usecase;

import com.gildedrose.domain.Item;
import com.gildedrose.pattern.ItemFactory;

public class GildedRose {
    public Item[] items;


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            ItemFactory.createItem(item).update(item);
        }
    }

}
