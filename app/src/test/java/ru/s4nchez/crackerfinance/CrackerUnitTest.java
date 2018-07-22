package ru.s4nchez.crackerfinance;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.Operation;
import ru.s4nchez.crackerfinance.model.OperationType;
import ru.s4nchez.crackerfinance.model.currency.Currencies;

import static org.junit.Assert.assertEquals;

public class CrackerUnitTest {

    @Test
    public void operations_isCorrect() {
        Cracker cracker = new Cracker();

        List<Operation> operations = new ArrayList<>();
        operations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 25000));
        operations.add(new Operation(OperationType.cost,
                Currencies.get().ruble(), 9999));

        double expected = 15001;
        double actual = cracker.getTotal(Currencies.get().ruble(), operations);

        assertEquals("getTotal error", expected, actual, 0);
    }
}