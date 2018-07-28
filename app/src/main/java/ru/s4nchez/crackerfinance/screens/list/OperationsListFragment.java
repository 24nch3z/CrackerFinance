package ru.s4nchez.crackerfinance.screens.list;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.s4nchez.crackerfinance.MyApplication;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.Screens;
import ru.s4nchez.crackerfinance.model.Repository;

public class OperationsListFragment extends Fragment {

    private Repository repository;
    private RecyclerView recyclerView;
    private OperationAdapter adapter;
    private FloatingActionButton fab;

    public static OperationsListFragment newInstance() {
        OperationsListFragment fragment = new OperationsListFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operations_list, container, false);
        repository = MyApplication.instance.getRepository();
        initViews(v);
        return v;
    }

    private void initViews(View v) {
        recyclerView = v.findViewById(R.id.recyclerView);
        adapter = new OperationAdapter(repository.getOperations(), getContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new MyItemDecoration(
                (int) getResources().getDimension(R.dimen.main_screen_recycler_view_margin)));
        recyclerView.setAdapter(adapter);

        fab = v.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyApplication.instance.getRouter().navigateTo(Screens.SCREEN_OPERATION_CREATOR);
            }
        });
    }
}