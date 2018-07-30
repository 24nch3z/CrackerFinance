package ru.s4nchez.crackerfinance.screens.settings;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemSelected;
import ru.s4nchez.crackerfinance.BaseFragment;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.vm.AppViewModel;

public class FragmentSettingsScreen extends BaseFragment implements ViewContract {

    @BindView(R.id.spinnerCurrency)
    Spinner spinnerCurrency;

    private SettingsScreenPresenter presenter;

    public static FragmentSettingsScreen newInstance() {
        return new FragmentSettingsScreen();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings_screen, container, false);
        butterKnifeUnbinder = ButterKnife.bind(this, view);
        presenter = new SettingsScreenPresenter(new SettingsScreenModel());
        presenter.attachView(this);
        presenter.initCurrencySpinner(getContext());
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

    @Override
    public void initCurrencySpinner(List<String> currencyList, int defaultPosition) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, currencyList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCurrency.setAdapter(adapter);
        spinnerCurrency.setSelection(defaultPosition);
    }

    @OnItemSelected(R.id.spinnerCurrency)
    void onItemSelectedCurrency(AdapterView<?> adapterView, View view, int i, long l) {
        presenter.onChooseNewCurrency(i, getContext());
        AppViewModel viewModel = ViewModelProviders.of(getActivity()).get(AppViewModel.class);
        MutableLiveData<Boolean> liveDataRatesIsLoaded = viewModel.getRatesIsLoaded();
        liveDataRatesIsLoaded.setValue(false);
    }
}