package com.shoppingcart;

import com.shoppingcart.ShoppingCart;

public class User {
    private String name;
    private String email;
    private UserGroup userGroup;
    private ShoppingCart shoppingCart = null;


    public User(String name, String email, UserGroup userGroup, ShoppingCart shoppingCart) {
        this.name = name;
        this.email = email;
        this.userGroup = userGroup;
        this.shoppingCart = shoppingCart;
    }

    public UserGroup getUserGroup() {
        return userGroup;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart = shoppingCart;
    }

    public void addProduct(Product product) {
        shoppingCart.getProducts().add(product);
    }

    public void removeProduct(Product product) {

    }

    public boolean isUserGroup(UserGroup userGroup) {
        return this.userGroup == userGroup;
    }
}
