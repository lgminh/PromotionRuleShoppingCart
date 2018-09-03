package com.shoppingcart;
import com.shoppingcart.ChainResponsibility.PromotionRuleInterface;

import java.util.Date;

public abstract class PromotionRuleDecorator implements PromotionRuleInterface {
    protected Date toDate;
    protected Date fromDate;
    protected String color;
    protected UserGroup userGroup;
    protected float subTotal;
    protected float discount;
    protected PromotionRule nextPromotionRule;
    protected PromotionRuleInterface promotionRuleInterface;

    public PromotionRuleDecorator(PromotionRuleInterface promotionRuleInterface) {
        this.promotionRuleInterface = promotionRuleInterface;
    }

    public PromotionRuleInterface getPromotionRuleInterface() {
        return promotionRuleInterface;
    }

    public void setPromotionRuleInterface(PromotionRuleInterface promotionRuleInterface) {
        this.promotionRuleInterface = promotionRuleInterface;
    }
}
