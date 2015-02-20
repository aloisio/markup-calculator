package com.nupack.markup;

import static com.nupack.model.CommonItemTypes.BOOKS;
import static com.nupack.model.CommonItemTypes.DRUGS;
import static com.nupack.model.CommonItemTypes.ELECTRONICS;
import static com.nupack.model.CommonItemTypes.FOOD;
import static com.nupack.model.CommonItemTypes.OTHER;
import static com.nupack.model.MoneyTest.assertMoneyEqualsUpToCents;

import java.math.BigDecimal;

import org.junit.Test;

import com.nupack.model.ItemType;
import com.nupack.model.Money;

public class MarkupCalculatorTest {

    private static final ItemType ZERO_MARKUP_ITEM = new ItemType() {
        @Override
        public BigDecimal getMarkup() {
            return BigDecimal.ZERO;
        }
    };

    private MarkupCalculator calculator = new MarkupCalculator();

    @Test
    public void should_return_base_price_for_a_0_person_project_with_0_percent_flat_markup_and_0_markup_item() {
        calculator = new MarkupCalculator(BigDecimal.ZERO);
        Money cost = calculator.calculateFinalCost(new Money(123.45), 0, ZERO_MARKUP_ITEM);
        assertMoneyEqualsUpToCents(new Money(123.45), cost);
    }

    @Test
    public void should_return_base_price_with_default_flat_markup_for_a_0_person_project_with_default_flat_markup_and_0_markup_item() {
        Money cost = calculator.calculateFinalCost(new Money(201.58), 0, ZERO_MARKUP_ITEM);
        assertMoneyEqualsUpToCents(new Money(211.66), cost);
    }

    @Test
    public void should_return_base_price_with_default_flat_markup_plus_default_person_markup_for_project_with_one_person_and_0_markup_item() {
        Money cost = calculator.calculateFinalCost(new Money(1327.49), 1, ZERO_MARKUP_ITEM);
        assertMoneyEqualsUpToCents(new Money(1410.59), cost);
    }

    @Test
    public void should_compute_cost_for_food_projects() {
        Money cost = calculator.calculateFinalCost(new Money(1299.99), 3, FOOD);
        assertMoneyEqualsUpToCents(new Money(1591.58), cost);
    }

    @Test
    public void should_compute_cost_for_pharmaceutical_projects() {
        Money cost = calculator.calculateFinalCost(new Money(5432.00), 1, DRUGS);
        assertMoneyEqualsUpToCents(new Money(6199.81), cost);
    }

    @Test
    public void should_compute_cost_for_book_projects() {
        Money cost = calculator.calculateFinalCost(new Money(12456.95), 4, BOOKS);
        assertMoneyEqualsUpToCents(new Money(13707.63), cost);
    }

    @Test
    public void should_compute_cost_for_electronics_projects() {
        Money cost = calculator.calculateFinalCost(new Money(200458.18), 18, ELECTRONICS);
        assertMoneyEqualsUpToCents(new Money(260154.63), cost);
    }

    @Test
    public void should_compute_cost_for_other_projects() {
        Money cost = calculator.calculateFinalCost(new Money(555.55), 100, OTHER);
        assertMoneyEqualsUpToCents(new Money(1283.32), cost);
    }
}
