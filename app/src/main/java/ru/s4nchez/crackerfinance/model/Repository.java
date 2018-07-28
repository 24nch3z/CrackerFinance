package ru.s4nchez.crackerfinance.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ru.s4nchez.crackerfinance.model.category.Categories;
import ru.s4nchez.crackerfinance.model.currency.Currencies;

public class Repository {

    private List<Operation> operations;

    public Repository() {
        operations = new ArrayList<>();
        Operation o1 = new Operation(OperationType.cost,
                Currencies.get().ruble(), 350);
        o1.setCategory(Categories.get().products());
        operations.add(o1);

        operations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 25000));
    };

    public void addOperation(Operation o) {
        operations.add(o);
    }

    public List<Operation> getOperations() {
        return operations;
    }

    public List<Operation> getCosts() {
        List<Operation> list = new ArrayList<>();
        for (Operation operation : operations) {
            if (operation.getType() == OperationType.cost) {
                list.add(operation);
            }
        }
        return list;
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

    public void removeOperation(int pos) {
        operations.remove(pos);
    }
}