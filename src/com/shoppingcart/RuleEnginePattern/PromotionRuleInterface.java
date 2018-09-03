package com.shoppingcart.RuleEnginePattern;

import com.shoppingcart.ShoppingCart;

public interface PromotionRuleInterface {
    public float applyRule(ShoppingCart shoppingCart);
}
