package com.shoppingcart;

import com.shoppingcart.RuleEnginePattern.AbstractPromotionRule;
import com.shoppingcart.RuleEnginePattern.UserGroupProductColorPromotionRule;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public void testClass() {
        ArrayList<Product> products = new ArrayList<Product>();
        ShoppingCart shoppingCart = new ShoppingCart(products);
        User user = new User("John Doe 1", "john.doe@example.com", UserGroup.GOLD, shoppingCart);
        shoppingCart.setUser(user);
        user.addProduct(new Product("Iphone Silver", 999, "Silver"));
        user.addProduct(new Product("Iphone Silver", 999, "Silver"));
        user.addProduct(new Product("Iphone Black", 899, "Black"));
//        float totalPrice = user.getShoppingCart().getTotalPrice();
//        PromotionRuleChain promotionRuleChain = new PromotionRuleChain();
//        float totalPricePromotionRule = promotionRuleChain.applyPromotionRules(user.getShoppingCart());
//        System.out.println("Before applying rule " + totalPrice);
//        System.out.println("After applying rule " + totalPricePromotionRule);

        AbstractPromotionRule promotionRule = new UserGroupProductColorPromotionRule(new Date(2018,1,1),
                new Date(2018,1,1), "Black", UserGroup.GOLD, 1500, 50);

        float discountedPrice = promotionRule.applyRule(shoppingCart);

        System.out.println("Before discount: " + shoppingCart.getTotalPrice());
        System.out.println("After discount: " + discountedPrice);
    }

    public static void main(String[] args) {
        // write your code
        UnitTest unitTest = new UnitTest();
        unitTest.test();
    }
}
