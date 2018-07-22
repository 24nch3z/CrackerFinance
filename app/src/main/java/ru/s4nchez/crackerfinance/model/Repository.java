package ru.s4nchez.crackerfinance.model;

import java.util.ArrayList;
import java.util.List;

import ru.s4nchez.crackerfinance.model.currency.Currencies;

public class Repository {

    private static Repository sRepository;

    private List<Operation> mOperations;

    private Repository() {
        mOperations = new ArrayList<>();
        mOperations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 25000));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 350));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 150));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 55));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 440));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 315));
        mOperations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 30));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 1193));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 550));
        mOperations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 550));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 123));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 12));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 500));
        mOperations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 540));
    }

    ;

    public static Repository get() {
        if (sRepository == null) {
            sRepository = new Repository();
        }
        return sRepository;
    }

    public void addOperation(Operation o) {
        mOperations.add(o);
    }

    public List<Operation> getOperations() {
        return mOperations;
    }
}