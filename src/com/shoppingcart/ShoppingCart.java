package com.shoppingcart;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ShoppingCart {
    private ArrayList<Product> productArray;
    private User user = null;

    public ShoppingCart(ArrayList<Product> products) {
        productArray = products;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public float getTotalPrice() {
        float totalPrice = 0;
        for (Product product: productArray
                ) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    public ArrayList<Product> getProducts() {
        return productArray;
    }
}
