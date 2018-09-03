package com.shoppingcart;

import java.util.Date;

public abstract class PromotionRule {
    protected Date toDate;
    protected Date fromDate;
    protected String color;
    protected UserGroup userGroup;
    protected float subTotal;
    protected float discount;
    protected PromotionRule nextPromotionRule;

    public void nextPromotionRule(PromotionRule promotionRule) {
        nextPromotionRule = promotionRule;
    }

    public abstract float apply(ShoppingCart shoppingCart);
}
