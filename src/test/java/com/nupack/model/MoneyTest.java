package com.nupack.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.nupack.model.Money;

public class MoneyTest {
    @Test
    public void should_provide_cents_method() {
        assertEquals(159158L, new Money(1591.5779).getCents());
    }
}
