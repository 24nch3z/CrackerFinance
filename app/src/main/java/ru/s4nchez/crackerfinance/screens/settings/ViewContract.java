package ru.s4nchez.crackerfinance.screens.settings;

import java.util.List;

public interface ViewContract {
    void initCurrencySpinner(List<String> currencyList, int defaultPosition);
}