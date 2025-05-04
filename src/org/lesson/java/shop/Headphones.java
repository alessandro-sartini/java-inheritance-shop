package org.lesson.java.shop;

import java.math.BigDecimal;

public class Headphones extends Product{
    private String color;
    private boolean isWireless;

    public Headphones(String name, String brand, BigDecimal price, float iva, String color,boolean isWireless) {
        super(name, brand, price, iva);
        this.color=color;
        this.isWireless=isWireless;
    }

    public void setColor(String newColor){
        this.color=newColor;
    }
    public String getColor(){
        return this.color;
    }
    public void setisWireless(boolean isWireless){
        this.isWireless=isWireless;
    }
    public boolean getisWireless(){
        return this.isWireless;
    }
    public String getisWirelessString(){
        if (isWireless) {

            return "Wirless";
            
        } else {
            return "Wired";
 
        }
    }

    @Override
    public BigDecimal getDiscountedPrice(boolean hasLoyaltyCard) {
        BigDecimal discountedPrice = super.getDiscountedPrice(hasLoyaltyCard); 

        if (hasLoyaltyCard && !this.isWireless) {
            return this.getPrice().multiply(new BigDecimal("0.93")); 
        }
        return discountedPrice;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", color: %s, %s", this.color, this.getisWirelessString());
    }

}
