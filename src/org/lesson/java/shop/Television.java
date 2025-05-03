package org.lesson.java.shop;

import java.math.BigDecimal;

public class Television extends Product {

    int inchs;
    boolean isSmart;

    public Television(String name, String brand, BigDecimal price, float iva, int inchs, boolean isSmart) {
        super(name, brand, price, iva);
        this.inchs = inchs;
        this.isSmart = isSmart;
    }

    public void setInchs(int newInchs) {
        this.inchs = newInchs;
    }

    public int getInchs() {
        return this.inchs;
    }

    public void setInchs(boolean newIsSmart) {
        this.isSmart = newIsSmart;
    }

    public boolean getIsSmart() {
        return isSmart;
    }

    public String getIsSmartStrng() {
        if (isSmart) {
            return "Smart-TV";
        } else {

            return "NO Smart-TV";
        }
    }
    @Override
    public String toString() {
        return super.toString() + String.format(", %s, inchs: %d", this.getIsSmartStrng(), this.inchs);
    }

}
