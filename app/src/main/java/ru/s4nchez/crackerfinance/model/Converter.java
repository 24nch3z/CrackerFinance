package ru.s4nchez.crackerfinance.model;

import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Converter {

    public double converter(Currency from, Currency to, double sum) {
        String label = from.getCode() + "-" + to.getCode();
        if (Rates.get().getData().containsKey(label)) {
            return Rates.get().getData().get(label) * sum;
        } else {
            return sum;
        }
    }
}