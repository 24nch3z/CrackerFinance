package ru.s4nchez.crackerfinance.model;

import java.util.List;

public class Account {

    private String name;
    private List<Operation> operations;

    public Account(String name, List<Operation> operations) {
        this.name = name;
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public String getName() {
        return name;
    }
}
