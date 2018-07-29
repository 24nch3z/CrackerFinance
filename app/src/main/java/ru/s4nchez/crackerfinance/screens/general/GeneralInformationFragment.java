package ru.s4nchez.crackerfinance.screens.general;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.s4nchez.crackerfinance.BaseFragment;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.AppViewModel;
import ru.s4nchez.crackerfinance.model.Account;
import ru.s4nchez.crackerfinance.utils.MyToast;

public class GeneralInformationFragment extends BaseFragment implements ViewContract {

    private static final String DIALOG_ID = "CHANGE_ACCOUNT_DIALOG";

    private MainScreenPresenter presenter;
    private Account account;

    @BindView(R.id.account)
    TextView viewAccount;

    @BindView(R.id.budget)
    TextView viewBudget;

    @BindView(R.id.frameAccount)
    CardView frameAccount;

    public static GeneralInformationFragment newInstance() {
        return new GeneralInformationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_general_information, container, false);

        butterKnifeUnbinder = ButterKnife.bind(this, v);

        viewAccount.setSelected(true);

        AppViewModel viewModel = ViewModelProviders
                .of(getActivity()).get(AppViewModel.class);
        MutableLiveData<Account> liveData = viewModel.getCurrentAccount();
        account = liveData.getValue();

        presenter = new MainScreenPresenter(new
                MainScreenModel(getContext().getApplicationContext(), account));
        presenter.attachView(this);

        liveData.observe(getActivity(), account -> updateUI(account));

//        updateUI(account);

        return v;
    }

    private void updateUI(Account account) {
        presenter.setAccount(account);
        presenter.showAccount();
        presenter.showBudget();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    @Override
    public void setBudget(String s) {
        viewBudget.setText(s);
    }

    @Override
    public void setAccount(String account) {
        viewAccount.setText(account);
    }

    @OnClick(R.id.frameAccount)
    void frameAccountOnClick(View view) {
        FragmentManager fm = getFragmentManager();
        ChangeAccountDialogFragment dialog = ChangeAccountDialogFragment.newInstance();
        dialog.show(fm, DIALOG_ID);
    }
}