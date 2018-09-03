package com.shoppingcart;

import com.shoppingcart.RuleEnginePattern.AbstractPromotionRule;
import com.shoppingcart.RuleEnginePattern.UserGroupProductColorPromotionRule;

import java.util.ArrayList;
import java.util.Date;

import  org.junit.Test;
import static org.junit.Assert.*;


public class UnitTest {
    @Test
    public void test() {
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

        float totalPrice = shoppingCart.getTotalPrice();
        assertTrue("Passed totalPrice before discount",totalPrice == 2897);

        AbstractPromotionRule promotionRule = new UserGroupProductColorPromotionRule(new Date(2018,1,1),
                new Date(2018,1,1), "Black", UserGroup.GOLD, 1500, 50);
        float discountedPrice = promotionRule.applyRule(shoppingCart);
        assertTrue("Passed totalPrice after discount",discountedPrice == 2897);
    }
}
