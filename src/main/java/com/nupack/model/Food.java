package com.nupack.model;

import java.math.BigDecimal;

public class Food implements ItemType {

    @Override
    public BigDecimal getMarkup() {
        return BigDecimal.valueOf(13);
    }
}
