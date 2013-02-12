package com.acme.organbay;

public class Organ {
    private String name;
    private int price;
    private String owner;
    
    public Organ(String name, int price, String owner) {
        super();
        this.name = name;
        this.price = price;
        this.owner = owner;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Organ [name=" + name + ", price=" + price + ", owner=" + owner + "]";
    }
    
    
}
