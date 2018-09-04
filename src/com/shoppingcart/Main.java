package com.shoppingcart;

import com.shoppingcart.RuleEnginePattern.AbstractPromotionRule;
import com.shoppingcart.RuleEnginePattern.UserGroupProductColorPromotionRule;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        // write your code
        UnitTest unitTest = new UnitTest();
//        unitTest.test();
        unitTest.PromotionRuleEvaluatorTester();
    }
}
