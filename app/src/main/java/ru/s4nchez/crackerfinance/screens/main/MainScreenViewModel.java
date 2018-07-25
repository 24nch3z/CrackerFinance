package ru.s4nchez.crackerfinance.screens.main;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MainScreenViewModel extends BaseObservable {

    private Model model;

    public MainScreenViewModel(Model model) {
        this.model = model;
    }

    @Bindable
    public Model getModel() {
        return model;
    }
}
