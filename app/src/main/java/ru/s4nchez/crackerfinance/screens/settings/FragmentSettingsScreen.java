package ru.s4nchez.crackerfinance.screens.settings;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.FragmentSettingsScreenBinding;

public class FragmentSettingsScreen extends Fragment {

    private SettingsScreenViewModel mViewModel;

    public static FragmentSettingsScreen newInstance() {
        FragmentSettingsScreen fragment = new FragmentSettingsScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentSettingsScreenBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_settings_screen, container, false);

        mViewModel = new SettingsScreenViewModel();
        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }
}