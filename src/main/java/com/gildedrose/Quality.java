package com.gildedrose;

public class Quality {

    int quality;

    public Quality(int quality) {
        if(quality < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quality = quality;
    }

}
