package ru.s4nchez.crackerfinance.model.currency;

public class Currency {

    private String mName;
    private String mCode;
    private String mSymbol;

    public Currency(String name, String code, String symbol) {
        mName = name;
        mCode = code;
        mSymbol = symbol;
    }

    public String getName() {
        return mName;
    }

    public String getCode() {
        return mCode;
    }

    public String getSymbol() {
        return mSymbol;
    }
}