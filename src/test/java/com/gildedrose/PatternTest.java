package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import com.gildedrose.domain.Item;
import com.gildedrose.pattern.Sulfuras;
import com.gildedrose.pattern.AgedBrie;
import com.gildedrose.pattern.BackstagePasses;
import com.gildedrose.pattern.Conjured;
import com.gildedrose.pattern.ItemFactory;
import com.gildedrose.pattern.ItemUpdate;
import com.gildedrose.pattern.NormalItem;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PatternTest {
    ItemFactory factory;

    @BeforeEach
    void setUp() {
        factory = new ItemFactory();
    }

    @Test
    @DisplayName("Strategy Factory를 사용하여 생성된 전략이 올바른 클래스인지 테스트한다")
    void testStrategies() {
        ItemUpdate itemUpdate = factory.createItem(new Item("Aged Brie", 0, 0));
        assertThat(itemUpdate).isInstanceOf(AgedBrie.class);
    }
}
