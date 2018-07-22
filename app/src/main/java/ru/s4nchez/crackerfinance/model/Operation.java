package ru.s4nchez.crackerfinance.model;

import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Operation {

    private double mSum;
    private Currency mCurrency;
    private OperationType mType;

    public Operation(OperationType type, Currency currency, double sum) {
        mSum = sum;
        mCurrency = currency;
        mType = type;
    }

    public double getSum() {
        return mSum;
    }

    public Currency getCurrency() {
        return mCurrency;
    }

    public OperationType getType() {
        return mType;
    }
}