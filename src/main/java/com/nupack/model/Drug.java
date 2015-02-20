package com.nupack.model;

import java.math.BigDecimal;

public class Drug implements ItemType {

    private static final BigDecimal DEFAULT_DRUG_MARKUP = BigDecimal.valueOf(7.5);

    @Override
    public BigDecimal getMarkup() {
        return DEFAULT_DRUG_MARKUP;
    }
}
