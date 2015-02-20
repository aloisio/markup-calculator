package com.nupack.model;

import java.math.BigDecimal;

public class Money {
    private static final BigDecimal ONE_HUNDRED = BigDecimal.valueOf(100);

    private final BigDecimal amount;

    public Money(double amountAsDouble) {
        this.amount = BigDecimal.valueOf(amountAsDouble);
    }

    public Money(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * Increase the Money amount by a percentage.
     * 
     * @param rate
     *            percentage to increase, for instance 5 for 5% increase.
     * @return the Money value increased.
     */
    public Money addPercent(BigDecimal rate) {
        return new Money(amount.multiply(BigDecimal.ONE.add(rate.divide(ONE_HUNDRED))));
    }

    public long getCents() {
        return roundToLong(ONE_HUNDRED.multiply(amount));
    }

    private long roundToLong(BigDecimal value) {
        return value.setScale(0, BigDecimal.ROUND_HALF_UP).longValue();
    }
}
