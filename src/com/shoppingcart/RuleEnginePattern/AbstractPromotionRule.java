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
        try {
            if (toDate.compareTo(fromDate) > 0) {
                Exception exception = new Exception();
                throw exception;
            }
            this.toDate = toDate;
            this.fromDate = fromDate;
            this.color = color;
            this.userGroup = userGroup;
            this.subTotal = subTotal;
            this.discount = discount;
        } catch (Exception e) {

        }


    }

    public AbstractPromotionRule(){

    }

    public boolean isNotExpired() {
        Date currentDate = new Date();
        return toDate.compareTo(currentDate) >= 0  && currentDate.compareTo(fromDate) <= 0;
    }
}
