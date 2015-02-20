package com.nupack.model;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.nupack.model.Money;

public class MoneyTest {
    @Test
    public void should_provide_cents_method() {
        assertEquals(159158L, new Money(1591.5779).getCents());
    }
    
    @Test
    public void should_add_percentage_to_amount() {
        assertEquals(new Money(1296.29).getCents(), new Money(1234.56).addPercent(BigDecimal.valueOf(5)).getCents());
    }
}
