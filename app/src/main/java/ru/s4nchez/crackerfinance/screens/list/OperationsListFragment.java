package ru.s4nchez.crackerfinance.screens.list;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.s4nchez.crackerfinance.MyApplication;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.Screens;
import ru.s4nchez.crackerfinance.model.Account;
import ru.s4nchez.crackerfinance.vm.AppViewModel;

public class OperationsListFragment extends Fragment {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private Account account;
    private OperationAdapter adapter;
    private AppViewModel viewModel;

    public static OperationsListFragment newInstance() {
        return new OperationsListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operations_list, container, false);

        ButterKnife.bind(this, v);
        viewModel = ViewModelProviders
                .of(getActivity()).get(AppViewModel.class);
        MutableLiveData<Account> liveData = viewModel.getCurrentAccount();
        account = liveData.getValue();
        liveData.observe(getActivity(), this::updateUI);

        initViews(v);
        return v;
    }

    private void updateUI(Account account) {
        this.account = account;
        if (adapter != null) {
            adapter.setItems(account.getOperations());
            adapter.notifyDataSetChanged();
        }
    }

    private void initViews(View v) {
        adapter = new OperationAdapter(account.getOperations(), getContext(), viewModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new MyItemDecoration(
                (int) getResources().getDimension(R.dimen.main_screen_recycler_view_margin)));
        recyclerView.setAdapter(adapter);
    }

    @OnClick(R.id.fab)
    void OnClickListener(View v) {
        MyApplication.instance.getRouter().navigateTo(Screens.SCREEN_OPERATION_CREATOR);
    }
}