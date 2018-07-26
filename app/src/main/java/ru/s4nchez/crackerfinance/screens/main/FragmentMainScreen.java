package ru.s4nchez.crackerfinance.screens.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.s4nchez.crackerfinance.R;

public class FragmentMainScreen extends Fragment implements ViewContract {

    private MainScreenPresenter presenter;
    private TextView textViewBudget;

    public static FragmentMainScreen newInstance() {
        FragmentMainScreen fragment = new FragmentMainScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_screen, container, false);
        presenter = new MainScreenPresenter(new MainScreenModel(getContext().getApplicationContext()));
        textViewBudget = v.findViewById(R.id.textViewBudget);
        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.attachView(this);
        presenter.setBudget();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void setBudget(String budget) {
        textViewBudget.setText(budget);
    }
}