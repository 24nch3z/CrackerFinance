package ru.s4nchez.crackerfinance.screens.general;

import android.content.Context;

import ru.s4nchez.crackerfinance.Settings;
import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.Repository;
import ru.s4nchez.crackerfinance.model.currency.Currencies;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class MainScreenModel {

    private Cracker cracker;
    private Repository repository;
    private Currency currency;

    public MainScreenModel(Context context, Repository repository) {
        this.repository = repository;
        cracker = new Cracker();
        initCurrency(context);
    }

    private void initCurrency(Context context) {
        String currencyCode = Settings.get().getCurrency(context);
        Currency currency = Currencies.get().getCurrencyByCode(currencyCode);
        this.currency = currency == null ? Currencies.get().ruble() : currency;
    }

    public double getTotal() {
        return cracker.getTotal(currency, repository.getOperations());
    }

    public Currency getCurrentCurrency() {
        return currency;
    }
}