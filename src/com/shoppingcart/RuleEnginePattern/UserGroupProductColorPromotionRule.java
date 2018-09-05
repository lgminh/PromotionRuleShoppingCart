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
        if (shoppingCart.getUser().isUserGroup(this.userGroup) && isNotExpired()) {
            for (Product product: shoppingCart.getProducts()
                 ) {
                if (product.getColor() == this.color) {
                    discountedProductPrice += product.getPrice();
                }

                if (discountedProductPrice > subTotal) {
                    return discount;
                }
            }
            return discountedProductPrice > subTotal ? discount : 0;
        } else {
            return 0;
        }
    }
}
