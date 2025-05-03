import java.math.BigDecimal;

import org.lesson.java.shop.Product;

public class Main {
    public static void main(String[] args) {

        Product tv= new Product("WOo che tv", "LG", new BigDecimal(120.20), 0.45f);
        System.out.println(tv.getIva());





    }
}
