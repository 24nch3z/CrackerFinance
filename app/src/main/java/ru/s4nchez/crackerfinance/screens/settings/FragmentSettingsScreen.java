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

public class FragmentSettingsScreen extends Fragment implements ViewContract {

    private SettingsScreenPresenter presenter;

    public static FragmentSettingsScreen newInstance() {
        FragmentSettingsScreen fragment = new FragmentSettingsScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_screen, container, false);
        presenter = new SettingsScreenPresenter(new SettingsScreenModel());
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.initCurrencySpinner(getContext());
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void initCurrencySpinner(List<String> currencyList, int defaultPosition) {
        Spinner spinner = getView().findViewById(R.id.spinnerCurrency);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, currencyList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(defaultPosition);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                presenter.onChooseNewCurrency(i, getContext());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }
}