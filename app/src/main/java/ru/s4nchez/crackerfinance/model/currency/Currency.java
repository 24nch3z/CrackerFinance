package ru.s4nchez.crackerfinance.model.currency;

public class Currency {

    final private String name;
    final private String code;
    final private String symbol;

    public Currency(String name, String code, String symbol) {
        this.name = name;
        this.code = code;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }
}