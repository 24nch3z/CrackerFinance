package ru.s4nchez.crackerfinance.model;

import java.util.List;

import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Cracker {

    private Converter converter;

    public Cracker() {
        converter = new Converter();
    }

    public double getTotal(Currency currency, List<Operation> operations) {
        double total = 0, operationSum;

        for (Operation operation : operations) {
            operationSum = converter.converter(operation.getCurrency(),
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
}