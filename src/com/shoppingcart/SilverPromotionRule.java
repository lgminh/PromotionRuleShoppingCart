package com.shoppingcart;

import java.util.Date;

public class SilverPromotionRule extends PromotionRule {
    public SilverPromotionRule(Date toDate, Date fromDate, UserGroup userGroup, float subTotal, float discount) {
        color = "Silver";
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.userGroup = userGroup;
        this.subTotal = subTotal;
        this.discount = discount;
    }

    public void nextPromotionRule(PromotionRule promotionRule) {
        nextPromotionRule = promotionRule;
    }

    @Override
    public float apply(ShoppingCart shoppingCart) {
        float subTotalPrice = 0;

        for (Product product: shoppingCart.getProducts()
                ) {
            if (product.getColor() == color && shoppingCart.getUser().getUserGroup() == userGroup) {
                subTotalPrice += product.getPrice();
            }
        }

        if (subTotalPrice >= subTotal) {
            subTotalPrice -= discount;
        }

        if (nextPromotionRule != null) {
            subTotalPrice += nextPromotionRule.apply(shoppingCart);
        }
        return subTotalPrice;
    }
}
