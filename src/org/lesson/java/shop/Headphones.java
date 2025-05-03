package org.lesson.java.shop;

import java.math.BigDecimal;

public class Headphones extends Product{
    private String color;
    private boolean isWirless;

    public Headphones(String name, String brand, BigDecimal price, float iva, String color,boolean isWirless) {
        super(name, brand, price, iva);
        this.color=color;
        this.isWirless=isWirless;
    }

    public void setColor(String newColor){
        this.color=newColor;
    }
    public String getColor(){
        return this.color;
    }
    public void setIsWirless(boolean isWirless){
        this.isWirless=isWirless;
    }
    public boolean getIsWirless(){
        return this.isWirless;
    }
    public String getIsWirlessString(){
        if (isWirless) {

            return "Wirless";
            
        } else {
            return "Wired";
 
        }
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", color: %s, %s", this.color, this.getIsWirlessString());
    }

}
