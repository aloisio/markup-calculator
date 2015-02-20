package com.nupack.markup;

import java.math.BigDecimal;

import com.nupack.model.ItemType;
import com.nupack.model.Money;

public class MarkupCalculator {

    private static final BigDecimal DEFAULT_FLAT_MARKUP = BigDecimal.valueOf(5);

    private static final BigDecimal PERSON_MARKUP = BigDecimal.valueOf(1.2);

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
        return basePrice
                .addPercent(flatMarkup)
                .addPercent(getVariableMarkup(numberOfPeople, itemType));
    }

    private BigDecimal getVariableMarkup(int numberOfPeople, ItemType itemType) {
        return getPeopleMarkup(numberOfPeople).add(itemType.getMarkup());
    }

    private BigDecimal getPeopleMarkup(int numberOfPeople) {
        return PERSON_MARKUP.multiply(BigDecimal.valueOf(numberOfPeople));
    }
}
