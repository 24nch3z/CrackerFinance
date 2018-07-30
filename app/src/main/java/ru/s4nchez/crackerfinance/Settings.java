package ru.s4nchez.crackerfinance;

import android.content.Context;

import ru.s4nchez.crackerfinance.utils.MySharedPref;

public class Settings {

    private static final Settings instance = new Settings();

    private static final String CURRENCY = "CURRENCY";
    private static final String DEFAULT_CURRENCY = "RUB";

    private Settings() {}

    public static Settings get() {
        return instance;
    }

    public void setCurrency(Context c, String currency) {
        MySharedPref.save(c, CURRENCY, currency);
    }

    public String getCurrency(Context c) {
        return MySharedPref.getString(c, CURRENCY, DEFAULT_CURRENCY);
    }
}