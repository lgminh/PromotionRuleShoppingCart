package com.shoppingcart.ChainResponsibility;

import com.shoppingcart.ShoppingCart;
import com.shoppingcart.User;

public interface PromotionRuleInterface {
    public float applyRule(ShoppingCart shoppingCart);
    public boolean isMatchUserGroup(User user);
}
