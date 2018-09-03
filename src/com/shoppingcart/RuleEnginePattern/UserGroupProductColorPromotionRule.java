package com.shoppingcart.RuleEnginePattern;

import com.shoppingcart.Product;
import com.shoppingcart.RuleEnginePattern.AbstractPromotionRule;
import com.shoppingcart.ShoppingCart;
import com.shoppingcart.UserGroup;

import java.util.Date;

public class UserGroupProductColorPromotionRule extends AbstractPromotionRule implements PromotionRuleInterface {

    public UserGroupProductColorPromotionRule(Date toDate, Date fromDate, String color, UserGroup userGroup, float subTotal, float discount) {
        super(toDate, fromDate, color, userGroup, subTotal, discount);
    }

    @Override
    public float applyRule(ShoppingCart shoppingCart) {
        float discountedProductPrice = 0;
        float nonDiscountProductPrice = 0;
        if (shoppingCart.getUser().isUserGroup(this.userGroup)) {
            for (Product product: shoppingCart.getProducts()
                 ) {
                if (product.isColor(this.color)) {
                    discountedProductPrice += product.getPrice();
                } else {
                    nonDiscountProductPrice += product.getPrice();
                }
            }

            if (discountedProductPrice > this.subTotal) {
                return discountedProductPrice - this.discount + nonDiscountProductPrice;
            } else {
                return discountedProductPrice + nonDiscountProductPrice;
            }

        } else {
            return -1;
        }
    }
}
