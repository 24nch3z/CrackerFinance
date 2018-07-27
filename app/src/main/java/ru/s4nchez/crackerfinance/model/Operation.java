package ru.s4nchez.crackerfinance.model;

import java.util.Date;

import ru.s4nchez.crackerfinance.model.category.Category;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Operation {

    final private double sum;
    final private Currency currency;
    final private OperationType type;
    private String description;
    private String name;
    private Date creatingDate;
    private Date operationDate;
    private Category category;

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

    public Date getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(Date creatingDate) {
        this.creatingDate = creatingDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Date operationDate) {
        this.operationDate = operationDate;
    }
}