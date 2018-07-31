package ru.s4nchez.crackerfinance.model;

import java.util.Date;

import ru.s4nchez.crackerfinance.model.category.Category;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Operation {

    private double sum;
    private Currency currency;
    private OperationType type;
    private String comment;
    private Date creatingDate;
    private Date operationDate;
    private Category category;

    public Operation() { }

    public Operation(OperationType type, Currency currency, double sum) {
        this.sum = sum;
        this.currency = currency;
        this.type = type;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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