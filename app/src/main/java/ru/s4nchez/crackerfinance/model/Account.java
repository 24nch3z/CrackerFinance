package ru.s4nchez.crackerfinance.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private String name;
    private List<Operation> operations;

    public Account() { }

    public Account(String name, List<Operation> operations) {
        this.name = name;
        this.operations = operations;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public String getName() {
        return name;
    }

    public void addOperation(Operation o) {
        operations.add(o);
    }

    public void removeOperation(int pos) {
        operations.remove(pos);
    }

    public List<Operation> getIncomes() {
        List<Operation> list = new ArrayList<>();
        for (Operation operation : operations) {
            if (operation.getType() == OperationType.income) {
                list.add(operation);
            }
        }
        return list;
    }
}
