package com.nupack.model;

import java.math.BigDecimal;

public class Drug implements ItemType {

    @Override
    public BigDecimal getMarkup() {
        return BigDecimal.valueOf(7.5);
    }

}
