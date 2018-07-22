package ru.s4nchez.crackerfinance.screens.main;

import android.content.Context;

import ru.s4nchez.crackerfinance.Settings;
import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.Repository;
import ru.s4nchez.crackerfinance.model.currency.Currencies;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Model {

    private Cracker mCracker;
    private Repository mRepository;

    private double mTotal;
    private Currency mCurrency;

    public Model(Cracker cracker, Repository repository, Context context) {
        mCracker = cracker;
        mRepository = repository;
        initCurrency(context);
        calculateTotal();
    }

    private void initCurrency(Context context) {
        String currencyCode = Settings.get().getCurrency(context);
        Currency currency = Currencies.get().getCurrencyByCode(currencyCode);
        mCurrency = currency == null ? Currencies.get().ruble() : currency;
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