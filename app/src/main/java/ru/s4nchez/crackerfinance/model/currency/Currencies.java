package ru.s4nchez.crackerfinance.model.currency;

public class Currencies {

    private static Currencies sCurrencies;

    private Currency mRuble;
    private Currency mDollar;

    private Currencies() {
        mRuble = new CurrencyRuble();
        mDollar = new CurrencyDollar();
    };

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