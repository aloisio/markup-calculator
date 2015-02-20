package com.nupack.model;

import java.math.BigDecimal;

public class Money {
    private final BigDecimal amount;

    public Money(double amountAsDouble) {
        this.amount = BigDecimal.valueOf(amountAsDouble);
    }

    public long getCents() {
        return BigDecimal.valueOf(100).multiply(amount).setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }
}
