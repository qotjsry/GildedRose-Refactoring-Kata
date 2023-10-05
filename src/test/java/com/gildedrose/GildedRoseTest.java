package com.gildedrose;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    @DisplayName("Item Quality가 0보다 작아지지 않는다.")
    public void not_minus_quality() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> {
            new Item("foo", 0, -1);
        });
    }

}
