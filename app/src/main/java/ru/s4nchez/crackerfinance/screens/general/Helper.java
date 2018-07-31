package ru.s4nchez.crackerfinance.screens.general;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.HttpUrl;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class Helper {

    public static HttpUrl getUrl(String q) {
        HttpUrl.Builder url = new HttpUrl.Builder();
        url.scheme("https");
        url.host("free.currencyconverterapi.com");
        url.encodedPath("/api/v6/convert");
        url.addEncodedQueryParameter("q", q);
        url.addEncodedQueryParameter("compact", "y");
        return url.build();
    }

    public static String getCurrencyParamForRequest(Currency currentCurrency, List<Currency> other) {
        List<String> result = new ArrayList<>();
        for (Currency currency : other) {
            result.add(currency.getCode() + "_" + currentCurrency.getCode());
        }
        return TextUtils.join(",", result);
    }

    public static String getRatesStringForView(String response, Currency currentCurrency,
                                               List<Currency> other) throws IOException, JSONException {
        JSONObject main = new JSONObject(response);
        StringBuilder result = new StringBuilder();

        for (Currency currency : other) {
            String name = currency.getCode() + "_" + currentCurrency.getCode();
            JSONObject rate = main.getJSONObject(name);
            double value = rate.getDouble("val");
            result.append(currency.getCode() + " -> " + currentCurrency.getCode() + ": " + value + "\n");
        }

        return result.toString().trim();
    }
}
