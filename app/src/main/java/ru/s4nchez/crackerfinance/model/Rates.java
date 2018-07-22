package ru.s4nchez.crackerfinance.model;

import java.util.HashMap;
import java.util.Map;

public class Rates {

    private static Rates sRates;

    private Map<String, Double> mData;

    private Rates() {
        mData = new HashMap<>();
        mData.put("RUB-USD", 0.016d);
        mData.put("USD-RUB", 63.28d);
    }

    public static Rates get() {
        if (sRates == null) {
            sRates = new Rates();
        }
        return sRates;
    }

    public Map<String, Double> getData() {
        return mData;
    }
}