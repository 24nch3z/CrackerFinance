package ru.s4nchez.crackerfinance.screens.general;

import ru.s4nchez.crackerfinance.BasePresenter;

public class MainScreenPresenter extends BasePresenter<ViewContract> {

    private MainScreenModel model;

    public MainScreenPresenter(MainScreenModel model) {
        this.model = model;
    }

    public void setBudget() {
        int sum = (int) model.getTotal();
        String currencySymbol = model.getCurrentCurrency().getSymbol();
        view.setBudget(sum + "" + currencySymbol);
    }
}
