package ru.s4nchez.crackerfinance.screens.main;

import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.Repository;
import ru.s4nchez.crackerfinance.model.currency.Currencies;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Model {

    private Cracker mCracker;
    private Repository mRepository;

    private double mTotal;
    private Currency mCurrency;

    public Model(Cracker cracker, Repository repository) {
        mCracker = cracker;
        mRepository = repository;
        mCurrency = Currencies.get().dollar();
        calculateTotal();
    }

    public void calculateTotal() {
        mTotal = mCracker.getTotal(mCurrency, mRepository.getOperations());
    }

    public double getTotal() {
        return mTotal;
    }

    public Currency getCurrency() {
        return mCurrency;
    }

    public void setCurrency(Currency currency) {
        mCurrency = currency;
    }
}