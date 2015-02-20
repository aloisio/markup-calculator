package com.nupack.markup;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.nupack.model.ItemType;
import com.nupack.model.Money;

public class MarkupCalculatorTest {

    private static final ItemType ZERO_MARKUP_ITEM = new ItemType() {
        @Override
        public BigDecimal getMarkup() {
            return BigDecimal.ZERO;
        }
    };

    @Test
    public void should_return_base_price_for_a_0_person_project_with_0_percent_flat_markup_and_0_markup_item() {
        MarkupCalculator calculator = new MarkupCalculator(BigDecimal.ZERO);
        Money cost = calculator.calculateFinalCost(new Money(123.45), 0, ZERO_MARKUP_ITEM);
        assertEquals(new Money(123.45).getCents(), cost.getCents());
    }
    
    @Test
    public void should_return_base_price_with_default_flat_markup_for_a_0_person_project_with_default_flat_markup_and_0_markup_item() {
        MarkupCalculator calculator = new MarkupCalculator();
        Money cost = calculator.calculateFinalCost(new Money(201.58), 0, ZERO_MARKUP_ITEM);
        assertEquals(new Money(211.66).getCents(), cost.getCents());
    }
}
