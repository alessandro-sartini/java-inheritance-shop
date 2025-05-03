package org.lesson.java.shop;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {

        Smartphone sm1 = new Smartphone("G7", "LG", new BigDecimal(120.20), 0.45f,256 );
        System.out.println(sm1.getStorage());

        Television tv1= new Television("oled fantastic", "Samsung",  new BigDecimal(999.99), 0, 70, true);
        System.out.println(tv1.getIsSmart());



    }
}
