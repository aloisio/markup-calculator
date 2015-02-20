package com.nupack.model;

import java.math.BigDecimal;

public enum CommonItemTypes implements ItemType {
    FOOD(13), DRUGS(7.5), ELECTRONICS(2), BOOKS(0);

    private CommonItemTypes(double markupAsDouble) {
        this.markup = BigDecimal.valueOf(markupAsDouble);
    }

    private final BigDecimal markup;

    @Override
    public BigDecimal getMarkup() {
        return markup;
    }
}
