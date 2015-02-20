package com.nupack.markup;

import java.math.BigDecimal;

import com.nupack.model.ItemType;
import com.nupack.model.Money;

public class MarkupCalculator {

    private static final BigDecimal DEFAULT_FLAT_MARKUP = BigDecimal.valueOf(5);

    private final BigDecimal flatMarkup;

    public MarkupCalculator() {
        this(DEFAULT_FLAT_MARKUP);
    }

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
        return basePrice.addPercent(flatMarkup);
    }
}
