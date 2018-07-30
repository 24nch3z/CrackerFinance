package ru.s4nchez.crackerfinance.screens.general;

import ru.s4nchez.crackerfinance.BasePresenter;
import ru.s4nchez.crackerfinance.model.Account;

public class MainScreenPresenter extends BasePresenter<ViewContract> {

    private MainScreenModel model;

    public MainScreenPresenter(MainScreenModel model) {
        this.model = model;
    }

    public void showBudget() {
        int sum = (int) model.getTotal();
        String currencySymbol = model.getCurrentCurrency().getSymbol();
        view.setBudget(sum + "" + currencySymbol);
    }

    public void showAccount() {
        view.setAccount(model.getAccountName());
    }

    public void setAccount(Account account) {
        model.setAccount(account);
    }
}
