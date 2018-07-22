package ru.s4nchez.crackerfinance.screens.main;

import android.databinding.BaseObservable;

import ru.s4nchez.crackerfinance.model.Cracker;

public class MainScreenViewModel extends BaseObservable {

    private Cracker mCracker;

    public MainScreenViewModel(Cracker cracker) {
        mCracker = cracker;
    }
}
