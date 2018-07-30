package ru.s4nchez.crackerfinance.screens.general;

import android.content.Context;

import ru.s4nchez.crackerfinance.Settings;
import ru.s4nchez.crackerfinance.model.Account;
import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.currency.Currencies;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class MainScreenModel {

    private Cracker cracker;
    private Account account;
    private Currency currency;

    public MainScreenModel(Context context, Account account) {
        this.account = account;
        cracker = new Cracker();
        initCurrency(context);
    }

    private void initCurrency(Context context) {
        String currencyCode = Settings.get().getCurrency(context);
        Currency currency = Currencies.get().getCurrencyByCode(currencyCode);
        this.currency = currency == null ? Currencies.get().ruble() : currency;
    }

    public double getTotal() {
        return cracker.getTotal(currency, account.getOperations());
    }

    public String getAccountName() {
        return account.getName();
    }

    public Currency getCurrentCurrency() {
        return currency;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}