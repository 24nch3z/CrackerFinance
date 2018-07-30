package ru.s4nchez.crackerfinance.screens.settings;

import android.content.Context;

public interface PresenterContract {
    //    void onChooseNewCurrency(int position, Context context);
//
//    List<String> getCurrencyList();
//
//    int getCurrentCurrencyPosition(Context context);
    void initCurrencySpinner(Context context);

    void onChooseNewCurrency(int position, Context context);
}