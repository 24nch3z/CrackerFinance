package ru.s4nchez.crackerfinance.model;

import java.util.Date;

import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Operation {

    private double mSum;
    private Currency mCurrency;
    private OperationType mType;

    private String mDescription;
    private String mName;
    private Date mDate;

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

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}