package ru.s4nchez.crackerfinance.model.currency;

public class CurrencyRuble implements Currency {

    @Override
    public String name() {
        return "Рубль";
    }

    @Override
    public String code() {
        return "RUB";
    }

    @Override
    public String symbol() {
        return "\u20BD";
    }
}
