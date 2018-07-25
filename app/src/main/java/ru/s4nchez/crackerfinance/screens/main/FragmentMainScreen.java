package ru.s4nchez.crackerfinance.screens.main;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.FragmentMainScreenBinding;
import ru.s4nchez.crackerfinance.model.Cracker;
import ru.s4nchez.crackerfinance.model.Repository;
import ru.s4nchez.crackerfinance.screens.main.list.MyItemDecoration;
import ru.s4nchez.crackerfinance.screens.main.list.OperationAdapter;

public class FragmentMainScreen extends Fragment {

    private MainScreenViewModel viewModel;
    private Model model;
    private Cracker cracker;
    private Repository repository = Repository.get();

    public static FragmentMainScreen newInstance() {
        FragmentMainScreen fragment = new FragmentMainScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentMainScreenBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_main_screen, container, false);

        cracker = new Cracker();
        model = new Model(cracker, repository, getContext());
        viewModel = new MainScreenViewModel(model);
        binding.setViewModel(viewModel);

        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        binding.recyclerView.addItemDecoration(new MyItemDecoration(20));
        binding.recyclerView.setAdapter(new OperationAdapter(
                repository.getOperations(), getContext()));

        return binding.getRoot();
    }
}