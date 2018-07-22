package ru.s4nchez.crackerfinance;

import org.junit.Test;

import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.Operation;
import ru.s4nchez.crackerfinance.model.OperationType;
import ru.s4nchez.crackerfinance.model.currency.CurrencyRuble;

import static org.junit.Assert.assertEquals;

public class CrackerUnitTest {

    @Test
    public void operations_isCorrect() {
        Cracker cracker = new Cracker();

        cracker.addOperation(new Operation(OperationType.income,
                new CurrencyRuble(), 6000));
        cracker.addOperation(new Operation(OperationType.cost,
                new CurrencyRuble(), 5000));
        double total = cracker.getTotal(new CurrencyRuble());

        assertEquals("getTotal error", 1000, total, 0);
    }
}