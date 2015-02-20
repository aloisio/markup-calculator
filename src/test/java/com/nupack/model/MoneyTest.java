package com.nupack.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

public class MoneyTest {
    @Test
    public void should_provide_cents_method() {
        assertEquals(159158L, new Money(1591.5779).getCents());
    }
    
    @Test
    public void should_add_percentage_to_amount() {
        assertMoneyEqualsUpToCents(new Money(1296.29), new Money(1234.56).addPercent(BigDecimal.valueOf(5)));
    }

    public static void assertMoneyEqualsUpToCents(Money expected, Money actual) {
        assertEquals(expected.getCents(), actual.getCents());
    }
}
