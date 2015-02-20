package com.nupack.markup;

import java.math.BigDecimal;

import com.nupack.model.ItemType;
import com.nupack.model.Money;

public class MarkupCalculator {

    private final BigDecimal flatMarkup;

    /**
     * Allows overwriting default flat markup rate.
     * 
     * @param flatMarkup
     *            percent value.
     */
    MarkupCalculator(BigDecimal flatMarkup) {
        this.flatMarkup = flatMarkup;
    }

    public Money calculateFinalCost(Money basePrice, int numberOfPeople, ItemType itemType) {
        return basePrice;
    }
}
