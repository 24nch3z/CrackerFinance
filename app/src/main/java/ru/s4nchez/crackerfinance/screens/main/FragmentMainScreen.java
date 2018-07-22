package ru.s4nchez.crackerfinance.screens.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.FragmentMainScreenBinding;
import ru.s4nchez.crackerfinance.model.Cracker;

public class FragmentMainScreen extends Fragment {

    private MainScreenViewModel mViewModel;
    private Cracker mCracker;

    public static FragmentMainScreen newInstance() {
        FragmentMainScreen fragment = new FragmentMainScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainScreenBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_main_screen, container, false);

        mCracker = new Cracker();
        mViewModel = new MainScreenViewModel(mCracker);
        binding.setViewModel(mViewModel);

        return binding.getRoot();
    }
}