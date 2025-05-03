package org.lesson.java.shop;

import java.math.BigDecimal;

public class Headphones extends Product{
    String color;
    boolean isWirless;

    public Headphones(String name, String brand, BigDecimal price, float iva, String color,boolean isWirless) {
        super(name, brand, price, iva);
        this.color=color;
        this.isWirless=isWirless;
    }

    

}
