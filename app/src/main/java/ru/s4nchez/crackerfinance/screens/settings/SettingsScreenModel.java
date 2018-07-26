package ru.s4nchez.crackerfinance.screens.settings;

import android.content.Context;

import java.util.List;

import ru.s4nchez.crackerfinance.Settings;
import ru.s4nchez.crackerfinance.model.currency.Currencies;

public class SettingsScreenModel {

    private List<String> currencyList;

    public SettingsScreenModel() {
        currencyList = Currencies.get().getCurrencyNames();
    }

    public List<String> getCurrencyList() {
        return currencyList;
    }

    public void onChooseNewCurrency(int position, Context context) {
        String currencyName = currencyList.get(position);
        String currencyCode = Currencies.get().getCodeByName(currencyName);
        Settings.get().setCurrency(context, currencyCode);
    }

    public int getCurrentCurrencyPosition(Context context) {
        String valueCode = Settings.get().getCurrency(context);
        String valueName = Currencies.get().getNameByCode(valueCode);
        int valuePosition = 0;
        for (int i = 0; i < currencyList.size(); i++) {
            if (currencyList.get(i).equalsIgnoreCase(valueName)) {
                valuePosition = i;
                break;
            }
        }

        return valuePosition;
    }
}
