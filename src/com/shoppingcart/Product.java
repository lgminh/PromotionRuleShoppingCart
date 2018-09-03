package com.shoppingcart;


public class Product {
    private String name;
    private float price;
    private String color;

    public Product(String name, float price, String color) {
        this.name = name;
        this.price = price;
        this.color = color;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public boolean isColor(String color) {
        return this.getColor() == color;
    }
}
