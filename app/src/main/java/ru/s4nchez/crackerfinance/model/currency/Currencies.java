package ru.s4nchez.crackerfinance.model.currency;

import java.util.ArrayList;
import java.util.List;

public class Currencies {

    private static Currencies instance;

    private List<Currency> currencies;

    private Currency ruble = new Currency("Рубль", "RUB", "\u20BD");
    private Currency dollar = new Currency("Доллар", "USD", "$");

    private Currencies() {
        currencies = new ArrayList<>();
        currencies.add(ruble);
        currencies.add(dollar);
    }

    public static Currencies get() {
        if (instance == null) {
            instance = new Currencies();
        }
        return instance;
    }

    public Currency ruble() {
        return ruble;
    }

    public Currency dollar() {
        return dollar;
    }

    public List<String> getCurrencyNames() {
        List<String> labels = new ArrayList<>(currencies.size());
        for (Currency c : currencies) {
            labels.add(c.getName());
        }
        return labels;
    }

    public String getCodeByName(String name) {
        for (Currency c : currencies) {
            if (name.equals(c.getName())) {
                return c.getCode();
            }
        }
        return null;
    }

    public String getNameByCode(String code) {
        for (Currency c : currencies) {
            if (code.equals(c.getCode())) {
                return c.getName();
            }
        }
        return null;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public Currency getCurrencyByCode(String code) {
        for (Currency currency : Currencies.get().getCurrencies()) {
            if (code.equalsIgnoreCase(currency.getCode())) {
                return currency;
            }
        }
        return null;
    }

    public Currency getCurrencyByName(String name) {
        for (Currency currency : Currencies.get().getCurrencies()) {
            if (name.equalsIgnoreCase(currency.getName())) {
                return currency;
            }
        }
        return null;
    }
}