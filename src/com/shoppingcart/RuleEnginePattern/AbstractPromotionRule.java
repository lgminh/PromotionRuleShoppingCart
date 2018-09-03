package com.shoppingcart.RuleEnginePattern;

import com.shoppingcart.UserGroup;

import java.util.Date;

public abstract class AbstractPromotionRule implements PromotionRuleInterface {
    protected Date toDate;
    protected Date fromDate;
    protected String color;
    protected UserGroup userGroup;
    protected float subTotal;
    protected float discount;

    public AbstractPromotionRule(Date toDate, Date fromDate, String color, UserGroup userGroup, float subTotal, float discount) {
        this.toDate = toDate;
        this.fromDate = fromDate;
        this.color = color;
        this.userGroup = userGroup;
        this.subTotal = subTotal;
        this.discount = discount;
    }

    public AbstractPromotionRule(){

    }
}
