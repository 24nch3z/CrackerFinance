package ru.s4nchez.crackerfinance.screens.main;

import android.content.Context;

import ru.s4nchez.crackerfinance.Settings;
import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.Repository;
import ru.s4nchez.crackerfinance.model.currency.Currencies;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Model {

    private Cracker cracker;
    private Repository repository;
    private double total;
    private Currency currency;

    public Model(Cracker cracker, Repository repository, Context context) {
        this.cracker = cracker;
        this.repository = repository;
        initCurrency(context);
        calculateTotal();
    }

    private void initCurrency(Context context) {
        String currencyCode = Settings.get().getCurrency(context);
        Currency currency = Currencies.get().getCurrencyByCode(currencyCode);
        this.currency = currency == null ? Currencies.get().ruble() : currency;
    }

    public void calculateTotal() {
        total = cracker.getTotal(currency, repository.getOperations());
    }

    public double getTotal() {
        return total;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}