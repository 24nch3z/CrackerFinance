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
import ru.s4nchez.crackerfinance.screens.main.list.OperationAdapter;

public class FragmentMainScreen extends Fragment {

    private MainScreenViewModel mViewModel;
    private Model mModel;
    private Cracker mCracker;
    private Repository mRepository = Repository.get();

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
        mModel = new Model(mCracker, mRepository);
        mViewModel = new MainScreenViewModel(mModel);
        binding.setViewModel(mViewModel);

        binding.recyclerView.setLayoutManager(
                new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(new OperationAdapter(
                mRepository.getOperations(), getContext()));

        return binding.getRoot();
    }
}