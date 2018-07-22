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