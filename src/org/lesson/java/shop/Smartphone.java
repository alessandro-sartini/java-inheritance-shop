package org.lesson.java.shop;

import java.math.BigDecimal;
import java.util.Random;

public class Smartphone extends Product{
    
    private int imei;
    private int storage;

    public Smartphone(String name, String brand, BigDecimal price, float iva, int storage) {
        super(name, brand, price, iva);
        Random rand= new Random();
        this.imei= rand.nextInt(99999999, 999999999);
        this.storage=storage;

    }
    public void setStorage(int newStorage){
        this.storage=newStorage;
    }
    public int getStorage(){
        return this.storage;
    }
    public void setImei(int newImei){
        this.imei=newImei;
    }
    public int getImei(){
        return this.imei;
    }

    @Override
    public String toString() {
        return super.toString()+ String.format(", storage: %dgb", storage);
    }





}
