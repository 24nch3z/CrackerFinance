package ru.s4nchez.crackerfinance.model;

import java.util.HashMap;
import java.util.Map;

public class Rates {

    private static Rates instance;

    private Map<String, Double> data;

    private Rates() {
        data = new HashMap<>();
        data.put("RUB-USD", 0.016d);
        data.put("RUB-EUR", 0.014d);

        data.put("EUR-RUB", 73.34d);
        data.put("EUR-USD", 1.17d);

        data.put("USD-RUB", 63.28d);
        data.put("USD-EUR", 0.86d);
    }

    public static Rates get() {
        if (instance == null) {
            instance = new Rates();
        }
        return instance;
    }

    public void clear() {
        data.clear();
    }

    public Map<String, Double> getData() {
        return data;
    }
}