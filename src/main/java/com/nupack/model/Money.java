package com.nupack.model;

import java.math.BigDecimal;

public class Money {
    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);
    
    private final BigDecimal amount;

    public Money(double amountAsDouble) {
        this.amount = BigDecimal.valueOf(amountAsDouble);
    }

    public long getCents() {
        return roundToLong(ONE_HUNDRED.multiply(amount));
    }

    private long roundToLong(BigDecimal value) {
        return value.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }
}
