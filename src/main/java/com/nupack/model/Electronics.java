package com.nupack.model;

import java.math.BigDecimal;

public class Electronics implements ItemType {

    private static final BigDecimal DEFAULT_ELECTRONICS_MARKUP = BigDecimal.valueOf(2);

    @Override
    public BigDecimal getMarkup() {
        return DEFAULT_ELECTRONICS_MARKUP;
    }
}
