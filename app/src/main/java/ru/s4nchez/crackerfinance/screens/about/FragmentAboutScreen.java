package ru.s4nchez.crackerfinance.screens.about;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.FragmentAboutScreenBinding;

public class FragmentAboutScreen extends Fragment {

    private AboutScreenViewModel mViewModel;

    public static FragmentAboutScreen newInstance() {
        FragmentAboutScreen fragment = new FragmentAboutScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAboutScreenBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_about_screen, container, false);

        mViewModel = new AboutScreenViewModel();
        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }
}