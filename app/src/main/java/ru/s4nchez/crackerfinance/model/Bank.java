package ru.s4nchez.crackerfinance.model;

import java.util.ArrayList;
import java.util.List;

import ru.s4nchez.crackerfinance.model.category.Categories;
import ru.s4nchez.crackerfinance.model.currency.Currencies;

public class Bank {

    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
        accounts.add(getAccountCash());
        accounts.add(getAccountCard());
    }

    private Account getAccountCash() {
        List<Operation> operations = new ArrayList<>();

        Operation o1 = new Operation(OperationType.cost,
                Currencies.get().ruble(), 350);
        o1.setCategory(Categories.get().products());
        operations.add(o1);

        operations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 5000));

        return new Account("Наличка", operations);
    }

    private Account getAccountCard() {
        List<Operation> operations = new ArrayList<>();

        operations.add(new Operation(OperationType.income,
                Currencies.get().ruble(), 25000));

        Operation o1 = new Operation(OperationType.cost,
                Currencies.get().ruble(), 1000);
        o1.setCategory(Categories.get().products());
        operations.add(o1);

        Operation o2 = new Operation(OperationType.cost,
                Currencies.get().ruble(), 3999);
        o1.setCategory(Categories.get().communal());
        operations.add(o2);

        return new Account("Карта Сбербанка", operations);
    }

    public List<String> getAccountsNames() {
        List<String> names = new ArrayList<>();
        for (Account account : accounts) {
            names.add(account.getName());
        }
        return names;
    }

    public Account getAccountByName(String name) {
        for (Account account : accounts) {
            if (account.getName().equals(name)) {
                return account;
            }
        }
        return null;
    }

    public Account getAccountByIndex(int i) {
        return accounts.get(i);
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
