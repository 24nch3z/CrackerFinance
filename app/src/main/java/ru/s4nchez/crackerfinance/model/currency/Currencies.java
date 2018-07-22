package ru.s4nchez.crackerfinance.model.currency;

public class Currencies {

    private static Currencies sCurrencies;

    private Currency mRuble = new Currency("Рубль", "RUB", "\u20BD");
    private Currency mDollar = new Currency("Доллар", "USD", "$");

    public static Currencies get() {
        if (sCurrencies == null) {
            sCurrencies = new Currencies();
        }
        return sCurrencies;
    }

    public Currency ruble() {
        return mRuble;
    }

    public Currency dollar() {
        return mDollar;
    }
}