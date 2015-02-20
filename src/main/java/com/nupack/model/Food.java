package com.nupack.model;

import java.math.BigDecimal;

public class Food implements ItemType {

    private static final BigDecimal DEFAULT_FOOD_MARKUP = BigDecimal.valueOf(13);

    @Override
    public BigDecimal getMarkup() {
        return DEFAULT_FOOD_MARKUP;
    }
}
