package com.gildedrose;

import static org.assertj.core.api.Assertions.assertThat;

import com.gildedrose.domain.Item;
import com.gildedrose.pattern.ItemFactory;
import com.gildedrose.usecase.GildedRose;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GildedRoseTest {
    private Item[] items;
    private GildedRose app;

    public void setUp(String name, int sellIn, int quality) {
        items = new Item[] { new Item(name, sellIn, quality) };
        app = new GildedRose(items);
    }

    public int itemSellIn() {
        return app.items[0].sellIn;
    }

    public int itemQuality() {
        return app.items[0].quality;
    }

    @Nested
    @DisplayName("일반 아이템은")
    public class NormalItem {
        @Test
        @DisplayName("1일 지날 때마다 sellIn과 quality가 1씩 감소한다.")
        public void normalItem_decrease() throws Exception {
            setUp("default",10,10);
            app.updateQuality();
            assertThat(itemSellIn()).isEqualTo(9);
            assertThat(itemQuality()).isEqualTo(9);
        }

    }

    @Nested
    @DisplayName("Aged Brie는")
    public class AgedBrie {
        @Test
        @DisplayName("시간이 지날수 록 quality 값이 올라간다.")
        public void agedBrie_decrease() throws Exception {
            setUp("Aged Brie",10,10);
            app.updateQuality();
            assertThat(itemSellIn()).isEqualTo(9);
            assertThat(itemQuality()).isEqualTo(11);
        }
    }

    @Nested
    @DisplayName("Sulfuras, Hand of Ragnaros는")
    public class Sulfuras {
        @Test
        @DisplayName("시간이 지나도 Quality 값이 변하지 않는다.")
        public void sulfuras_decrease() throws Exception {
            setUp("Sulfuras, Hand of Ragnaros",10,80);
            app.updateQuality();
            assertThat(itemSellIn()).isEqualTo(10);
            assertThat(itemQuality()).isEqualTo(80);
        }
    }

    @Nested
    @DisplayName("Backstage passes는")
    public class BackstagePasses {
        @Test
        @DisplayName("sellIn이 10일이 초과로 남았을 때 quality 값이 1씩 증가한다.")
        public void backstagePasses_decrease_more_10day() throws Exception {
            setUp("Backstage passes to a TAFKAL80ETC concert",11,10);
            app.updateQuality();
            assertThat(itemSellIn()).isEqualTo(10);
            assertThat(itemQuality()).isEqualTo(11);
        }

        @Test
        @DisplayName("sellIn이 10일 이하로 남고 5일 초과로 남았을 때 quality 값이 2씩 증가한다.")
        public void backstagePasses_decrease_more_5day_less_10day() throws Exception {
            setUp("Backstage passes to a TAFKAL80ETC concert",6,10);
            app.updateQuality();
            assertThat(itemSellIn()).isEqualTo(5);
            assertThat(itemQuality()).isEqualTo(12);
        }

        @Test
        @DisplayName("sellIn이 5일 이하로 남고 0일 초과로 남았을 때 quality 값이 3씩 증가한다.")
        public void backstagePasses_decrease_more_0day_less_5day() throws Exception {
            setUp("Backstage passes to a TAFKAL80ETC concert",1,10);
            app.updateQuality();
            assertThat(itemSellIn()).isEqualTo(0);
            assertThat(itemQuality()).isEqualTo(13);
        }

        @Test
        @DisplayName("sellIn이 0일(콘서트 종료 시) quality는 0이 된다.")
        public void backstagePasses_decrease_0day() throws Exception {
            setUp("Backstage passes to a TAFKAL80ETC concert",0,10);
            app.updateQuality();
            assertThat(itemSellIn()).isEqualTo(-1);
            assertThat(itemQuality()).isEqualTo(0);
        }
    }


}
