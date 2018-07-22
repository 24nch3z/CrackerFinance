package ru.s4nchez.crackerfinance.screens.settings;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.Settings;
import ru.s4nchez.crackerfinance.model.currency.Currencies;

public class FragmentSettingsScreen extends Fragment {

    public static FragmentSettingsScreen newInstance() {
        FragmentSettingsScreen fragment = new FragmentSettingsScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_screen, container, false);
        initCurrencySpinner(view);
        return view;
    }

    private void initCurrencySpinner(View view) {
        final List<String> currencyList = Currencies.get().getCurrencyNames();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, currencyList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner = view.findViewById(R.id.spinnerCurrency);
        spinner.setAdapter(adapter);

        String valueCode = Settings.get().getCurrency(getContext());
        String valueName = Currencies.get().getNameByCode(valueCode);
        int valuePosition = 0;
        for (int i = 0; i < currencyList.size(); i++) {
            if (currencyList.get(i).equalsIgnoreCase(valueName)) {
                valuePosition = i;
                break;
            }
        }
        spinner.setSelection(valuePosition);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String currencyName = currencyList.get(i);
                String currencyCode = Currencies.get().getCodeByName(currencyName);
                Settings.get().setCurrency(getContext(), currencyCode);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}