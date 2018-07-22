package ru.s4nchez.crackerfinance.model.currency;

public class CurrencyDollar implements Currency {

    @Override
    public String name() {
        return "Доллар";
    }

    @Override
    public String code() {
        return "USD";
    }

    @Override
    public String symbol() {
        return "$";
    }
}