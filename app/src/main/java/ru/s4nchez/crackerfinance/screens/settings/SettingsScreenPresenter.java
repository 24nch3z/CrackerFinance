package ru.s4nchez.crackerfinance.screens.settings;

import android.content.Context;

import java.util.List;

import ru.s4nchez.crackerfinance.BasePresenter;

public class SettingsScreenPresenter extends BasePresenter<ViewContract> {

    private SettingsScreenModel model;

    public SettingsScreenPresenter(SettingsScreenModel model) {
        this.model = model;
    }

    public void initCurrencySpinner(Context context) {
        List<String> currencyList = model.getCurrencyList();
        int defaultPosition = model.getCurrentCurrencyPosition(context);
        view.initCurrencySpinner(currencyList, defaultPosition);
    }

    public void onChooseNewCurrency(int position, Context context) {
        model.onChooseNewCurrency(position, context);
    }
}