package ru.s4nchez.crackerfinance.model;

import java.util.ArrayList;
import java.util.List;

import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Cracker {

    private Converter mConverter;
    private List<Operation> mOperations;

    public Cracker() {
        mConverter = new Converter();
        mOperations = new ArrayList<>();
    }

    public double getTotal(Currency currency) {
        double total = 0, operationSum;

        for (Operation operation : mOperations) {
            operationSum = mConverter.converter(operation.getCurrency(),
                    currency, operation.getSum());

            switch (operation.getType()) {
                case cost:
                    total -= operationSum;
                    break;
                case income:
                    total += operationSum;
                    break;
            }
        }

        return total;
    }

    public List<Operation> getOperations() {
        return mOperations;
    }

    public void addOperation(Operation operation) {
        mOperations.add(operation);
    }
}