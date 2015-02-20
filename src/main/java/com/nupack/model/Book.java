package com.nupack.model;

import java.math.BigDecimal;

public class Book implements ItemType {

    private static final BigDecimal DEFAULT_BOOK_MARKUP = BigDecimal.ZERO;

    @Override
    public BigDecimal getMarkup() {
        return DEFAULT_BOOK_MARKUP;
    }
}
