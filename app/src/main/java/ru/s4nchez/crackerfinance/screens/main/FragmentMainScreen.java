package ru.s4nchez.crackerfinance.screens.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.model.Repository;
import ru.s4nchez.crackerfinance.screens.main.list.MyItemDecoration;
import ru.s4nchez.crackerfinance.screens.main.list.OperationAdapter;

public class FragmentMainScreen extends Fragment implements ViewContract {

    private Repository repository;
    private MainScreenPresenter presenter;
    private TextView textViewBudget;
    private RecyclerView recyclerView;
    private OperationAdapter adapter;

    public static FragmentMainScreen newInstance() {
        FragmentMainScreen fragment = new FragmentMainScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_screen, container, false);
        repository = Repository.get();
        presenter = new MainScreenPresenter(new
                MainScreenModel(getContext().getApplicationContext(), repository));
        initViews(v);
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

    private void initViews(View v) {
        textViewBudget = v.findViewById(R.id.textViewBudget);
        recyclerView = v.findViewById(R.id.recyclerView);

        adapter = new OperationAdapter(repository.getOperations(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new MyItemDecoration(
                (int) getResources().getDimension(R.dimen.main_screen_recycler_view_margin)));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setBudget(String budget) {
        textViewBudget.setText(budget);
    }
}