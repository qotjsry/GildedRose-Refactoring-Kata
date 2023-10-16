package com.gildedrose.pattern;

import com.gildedrose.domain.Item;
import java.util.HashMap;

public class ItemFactory {

    public static final String DEFAULT_ITEM = "default";
    private static final HashMap<String, ItemUpdate> strategies = new HashMap<>();

    static {
        strategies.put("Aged Brie", new AgedBrie());
        strategies.put("Sulfuras, Hand of Ragnaros", new Sulfuras());
        strategies.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePasses());
        strategies.put("Conjured Mana Cake", new Conjured());
        strategies.put(DEFAULT_ITEM, new NormalItem());
    }

    public static ItemUpdate createItem(Item item) {
        return getItemUpdateInstance(item);
    }

    private static ItemUpdate getItemUpdateInstance(Item item) {
        return strategies.getOrDefault(item.name, strategies.get(DEFAULT_ITEM));
    }
}
