package ru.s4nchez.crackerfinance.model;

import java.util.Date;

import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Operation {

    final private double sum;
    final private Currency currency;
    final private OperationType type;
    private String description;
    private String name;
    private Date date;

    public Operation(OperationType type, Currency currency, double sum) {
        this.sum = sum;
        this.currency = currency;
        this.type = type;
    }

    public double getSum() {
        return sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public OperationType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}