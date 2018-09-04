package com.shoppingcart.ChainResponsibility;

import com.shoppingcart.PromotionRule;
import com.shoppingcart.ShoppingCart;
import com.shoppingcart.UserGroup;

import java.util.Date;

public class PromotionRuleChain  {
    public float applyPromotionRules(ShoppingCart shoppingCart) {
        PromotionRule blackPromotionRule = new BlackPromotionRule(new Date(2018,1,1),
                new Date(2018,2,1), UserGroup.GOLD, 1500, 50);
        PromotionRule silverPromotionRule = new SilverPromotionRule(new Date(2018,1,1),
                new Date(2018,2,1), UserGroup.GOLD, 1200, 100);
        blackPromotionRule.nextPromotionRule(silverPromotionRule);
        silverPromotionRule.nextPromotionRule(null);
        float totalPrice = blackPromotionRule.apply(shoppingCart);
        return totalPrice;
    }
}
