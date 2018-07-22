package ru.s4nchez.crackerfinance.model.currency;

import java.util.ArrayList;
import java.util.List;

public class Currencies {

    private static Currencies sCurrencies;

    private List<Currency> mCurrencies;

    private Currency mRuble = new Currency("Рубль", "RUB", "\u20BD");
    private Currency mDollar = new Currency("Доллар", "USD", "$");

    private Currencies() {
        mCurrencies = new ArrayList<>();
        mCurrencies.add(mRuble);
        mCurrencies.add(mDollar);
    }

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

    public List<String> getCurrencyNames() {
        List<String> labels = new ArrayList<>(mCurrencies.size());
        for (Currency c : mCurrencies) {
            labels.add(c.getName());
        }
        return labels;
    }

    public String getCodeByName(String name) {
        for (Currency c : mCurrencies) {
            if (name.equals(c.getName())) {
                return c.getCode();
            }
        }
        return null;
    }

    public String getNameByCode(String code) {
        for (Currency c : mCurrencies) {
            if (code.equals(c.getCode())) {
                return c.getName();
            }
        }
        return null;
    }

    public List<Currency> getCurrencies() {
        return mCurrencies;
    }

    public Currency getCurrencyByCode(String code) {
        for (Currency currency : Currencies.get().getCurrencies()) {
            if (code.equalsIgnoreCase(currency.getCode())) {
                return currency;
            }
        }
        return null;
    }
}