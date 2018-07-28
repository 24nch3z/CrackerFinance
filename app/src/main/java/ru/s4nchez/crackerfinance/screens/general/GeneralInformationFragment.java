package ru.s4nchez.crackerfinance.screens.general;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.s4nchez.crackerfinance.BaseFragment;
import ru.s4nchez.crackerfinance.MyApplication;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.model.Repository;

public class GeneralInformationFragment extends BaseFragment implements ViewContract {

    private Repository repository;
    private MainScreenPresenter presenter;

//    @BindView(R.id.textViewBudget)
//    TextView textViewBudget;

    public static GeneralInformationFragment newInstance() {
        return new GeneralInformationFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_general_information, container, false);
        ;

        butterKnifeUnbinder = ButterKnife.bind(this, v);
        repository = MyApplication.instance.getRepository();
        presenter = new MainScreenPresenter(new
                MainScreenModel(getContext().getApplicationContext(), repository));

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

//    @Override
//    public void setMenuVisibility(final boolean visible) {
//        super.setMenuVisibility(visible);
//    }

    @Override
    public void setBudget(String budget) {
//        textViewBudget.setText(budget);
    }
}