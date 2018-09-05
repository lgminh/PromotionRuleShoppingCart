package com.shoppingcart.RuleEnginePattern;

import com.shoppingcart.ShoppingCart;
import com.shoppingcart.UserGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionRuleEvaluator {
    protected ShoppingCart shoppingCart;
    protected List<AbstractPromotionRule> promotionRuleEvaluatorList = new ArrayList<AbstractPromotionRule>();

    public PromotionRuleEvaluator(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
        AbstractPromotionRule firstPromotionRule = new UserGroupProductColorPromotionRule(new Date(2018,1,1),
                new Date(2018,10,1), "Black", UserGroup.GOLD, 1500, 50);
        promotionRuleEvaluatorList.add(firstPromotionRule);
    }

    public float evaluateRules() {
        float totalPrice = shoppingCart.getTotalPrice();
        float discountedPrice = 0;
        for (AbstractPromotionRule promotionRule: promotionRuleEvaluatorList
             ) {
            discountedPrice += promotionRule.applyRule(shoppingCart);
        }
        return totalPrice - discountedPrice;
    }
}
