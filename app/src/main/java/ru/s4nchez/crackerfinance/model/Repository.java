package ru.s4nchez.crackerfinance.model;

import java.util.ArrayList;
import java.util.List;

import ru.s4nchez.crackerfinance.model.currency.Currencies;

public class Repository {

    private static Repository instance;

    private List<Operation> operations;

    private Repository() {
        operations = new ArrayList<>();
        operations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 25000));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 350));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 150));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 55));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 440));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 315));
        operations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 30));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 1193));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 550));
        operations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 550));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 123));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 12));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 500));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 540));
    }

    ;

    public static Repository get() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    public void addOperation(Operation o) {
        operations.add(o);
    }

    public List<Operation> getOperations() {
        return operations;
    }
}