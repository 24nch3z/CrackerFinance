package ru.s4nchez.crackerfinance.screens.operation;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.OnTextChanged;
import ru.s4nchez.crackerfinance.BaseFragment;
import ru.s4nchez.crackerfinance.MyApplication;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.AppViewModel;
import ru.s4nchez.crackerfinance.Screens;
import ru.s4nchez.crackerfinance.model.Account;
import ru.s4nchez.crackerfinance.utils.MyToast;

public class OperationCreatorFragment extends BaseFragment implements ViewContract {

    private OperationCreatorModel model;
    private OperationCreatorPresenter presenter;
//    private Repository repository;
    private Account account;

    @BindView(R.id.comment)
    TextInputEditText comment;

    @BindView(R.id.sum)
    TextInputEditText sum;

    @BindView(R.id.operationType)
    Spinner operationType;

    @BindView(R.id.currency)
    Spinner currency;

    @BindView(R.id.category)
    Spinner category;

    @BindView(R.id.date)
    Button date;

    @BindView(R.id.sumError)
    TextView sumError;

    @BindView(R.id.categoryLabel)
    TextView categoryLabel;


    public static OperationCreatorFragment newInstance() {
        return new OperationCreatorFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_operation_creator, container, false);

        butterKnifeUnbinder = ButterKnife.bind(this, v);

        AppViewModel viewModel = ViewModelProviders
                .of(getActivity()).get(AppViewModel.class);
        MutableLiveData<Account> liveData = viewModel.getCurrentAccount();
        account = liveData.getValue();

        model = new OperationCreatorModel();
        presenter = new OperationCreatorPresenter(model, account);
        presenter.attachView(this);

        presenter.initOperationType();
        presenter.initCurrency();
        presenter.initCategory();
        presenter.initDate();

        initToolbar();

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.detachView();
    }

    private void initToolbar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Создание операции");
    }

    @Override
    public void setSum(String s) {
        sum.setText(s);
    }

    @Override
    public void setDate(String s) {
        date.setText(s);
    }

    @Override
    public void exitFromScreen() {
        MyToast.get(getContext()).show("Операция успешно создана");
        MyApplication.instance.getRouter().backTo(Screens.SCREEN_MAIN);
    }

    @Override
    public void showSumError(int textErrorId) {
        sumError.setText(getText(textErrorId));
        sumError.setVisibility(View.VISIBLE);
    }

    @Override
    public void showHideCategory(boolean flag) {
        category.setVisibility(flag ? View.VISIBLE : View.GONE);
        categoryLabel.setVisibility(flag ? View.VISIBLE : View.GONE);
    }

    @Override
    public void setComment(String s) {
        comment.setText(s);
    }

    @Override
    public void initOperationType(List<String> list, int selection) {
        initSpinner(list, selection, operationType);
    }

    @Override
    public void initCurrency(List<String> list, int selection) {
        initSpinner(list, selection, currency);
    }

    @Override
    public void initCategory(List<String> list, int selection) {
        initSpinner(list, selection, category);
    }

    private void initSpinner(List<String> list, int selection, Spinner spinner) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_spinner_item, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setSelection(selection);
    }

    @OnItemSelected(R.id.operationType)
    void onItemSelectedOperationType(AdapterView<?> adapterView, View view, int i, long l) {
        presenter.setOperationType((int) l);
    }

    @OnItemSelected(R.id.category)
    void onItemSelectedOperationCategory(AdapterView<?> adapterView, View view, int i, long l) {
        presenter.setCategory((int) l);
    }

    @OnItemSelected(R.id.currency)
    void onItemSelectedOperationCurrency(AdapterView<?> adapterView, View view, int i, long l) {
        presenter.setCurrency((int) l);
    }

    @OnClick({ R.id.save, R.id.date })
    void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.save:
                presenter.save();
                break;
            case R.id.date:

                break;
        }
    }

    @OnTextChanged(R.id.comment)
    void onTextChangedComment(CharSequence s, int start, int before, int count) {
        presenter.setComment(s);
    }

    @OnTextChanged(R.id.sum)
    void onTextChangedSum(CharSequence s, int start, int before, int count) {
        presenter.setSum(s);
        sumError.setVisibility(View.GONE);
    }
}