package com.gildedrose.pattern;

import com.gildedrose.domain.Item;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.function.Supplier;

public class ItemFactory {

    public static final String DEFAULT_ITEM = "default";
    private static final HashMap<String, Supplier<? extends ItemUpdate>> strategies = new HashMap<>();

    static {
        strategies.put("Aged Brie", AgedBrie::new);
        strategies.put("Sulfuras, Hand of Ragnaros", Sulfuras::new);
        strategies.put("Backstage passes to a TAFKAL80ETC concert", BackstagePasses::new);
        strategies.put("Conjured Mana Cake", Conjured::new);
        strategies.put(DEFAULT_ITEM, NormalItem::new);
    }

    public static ItemUpdate createItem(Item item) {
        return getItemUpdateInstance(item);
    }

    private static ItemUpdate getItemUpdateInstance(Item item) {
        return strategies.getOrDefault(item.name, strategies.get(DEFAULT_ITEM)).get();
    }
}
