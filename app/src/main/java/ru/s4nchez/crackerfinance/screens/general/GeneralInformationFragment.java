package ru.s4nchez.crackerfinance.screens.general;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.s4nchez.crackerfinance.BaseFragment;
import ru.s4nchez.crackerfinance.MyApplication;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.RepositoryViewModel;
import ru.s4nchez.crackerfinance.model.Repository;
import ru.s4nchez.crackerfinance.utils.MyLog;

public class GeneralInformationFragment extends BaseFragment implements ViewContract {

    private Repository repository;
    private MainScreenPresenter presenter;

    @BindView(R.id.account)
    TextView account;

    @BindView(R.id.budget)
    TextView budget;

    public static GeneralInformationFragment newInstance() {
        return new GeneralInformationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_general_information, container, false);

        butterKnifeUnbinder = ButterKnife.bind(this, v);

        RepositoryViewModel viewModel = ViewModelProviders
                .of(getActivity()).get(RepositoryViewModel.class);
        MutableLiveData<Repository> liveData = viewModel.getRepository();
        repository = liveData.getValue();
        liveData.observe(this, new Observer<Repository>() {
            @Override
            public void onChanged(@Nullable Repository repository) {
                presenter.setBudget();
            }
        });

        account.setSelected(true);

        presenter = new MainScreenPresenter(new
                MainScreenModel(getContext().getApplicationContext(), repository));
        presenter.attachView(this);
        presenter.setBudget();

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void setBudget(String s) {
        budget.setText(s);
    }
}