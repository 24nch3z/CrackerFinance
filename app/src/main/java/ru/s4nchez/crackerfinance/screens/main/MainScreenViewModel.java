package ru.s4nchez.crackerfinance.screens.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MainScreenViewModel extends BaseObservable {

    private Model mModel;

    public MainScreenViewModel(Model model) {
        mModel = model;
    }

    @Bindable
    public Model getModel() {
        return mModel;
    }
}
