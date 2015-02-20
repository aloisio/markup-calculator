package com.nupack.markup;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.nupack.model.ItemType;
import com.nupack.model.Money;

public class MarkupCalculatorTest {

    @Test
    public void should_return_base_price_for_a_0_person_project_with_0_percent_flat_markup_and_0_markup_item() {
        MarkupCalculator calculator = new MarkupCalculator(BigDecimal.ZERO);
        ItemType item = new ItemType() {
            @Override
            public BigDecimal getMarkup() {
                return BigDecimal.ZERO;
            }
        };
        Money cost = calculator.calculateFinalCost(new Money(123.45), 0, item);
        assertEquals(new Money(123.45).getCents(), cost.getCents());
    }
}
