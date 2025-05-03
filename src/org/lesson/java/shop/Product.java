package org.lesson.java.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Product {

    private String name;
    private int code;
    private String brand;
    private BigDecimal price;
    private float iva;

    public Product(String name, String brand, BigDecimal price, float iva) {
        Random rand = new Random();
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.iva = iva;
        if (this.iva == 0.0) {
            this.iva = 0.22f;
        }

        setCode(rand.nextInt(9999));
        // this.code=rand.nextInt(9999);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String updatedName) {
        this.name = updatedName;
    }

    public int getCode() {
        return this.code;
    }

    private void setCode(int updatedCode) {
        this.code = updatedCode;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String updatedBrand) {
        this.brand = updatedBrand;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal updatedPrice) {
        this.price = updatedPrice;
    }

    public float getIva() {
        return this.iva;
    }

    public void setIva(float updatedIva) {
        this.iva = updatedIva;
    }

}
