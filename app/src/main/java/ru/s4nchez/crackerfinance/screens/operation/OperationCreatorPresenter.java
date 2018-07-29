package ru.s4nchez.crackerfinance.screens.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ru.s4nchez.crackerfinance.BasePresenter;
import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.model.Account;
import ru.s4nchez.crackerfinance.model.OperationType;
import ru.s4nchez.crackerfinance.model.category.Categories;
import ru.s4nchez.crackerfinance.model.category.Category;
import ru.s4nchez.crackerfinance.model.currency.Currencies;
import ru.s4nchez.crackerfinance.model.currency.Currency;

public class OperationCreatorPresenter extends BasePresenter<ViewContract> {

    private OperationCreatorModel model;
//    private Repository repository;
    private Account account;

    public OperationCreatorPresenter(OperationCreatorModel model, Account account) {
        this.model = model;
        this.account = account;
    }

    public void setSum(CharSequence sumStr) {
        double sum = 0.0;
        try {
            sum = Double.parseDouble(sumStr.toString());
        } catch (NumberFormatException e) {}
        model.getOperation().setSum(sum);
    }

    public void setComment(CharSequence sum) {
        model.getOperation().setComment(sum.toString());
    }

    public void setOperationType(int position) {
        OperationType type = OperationType.cost;
        if (position > 0) {
            type = OperationType.income;
            view.showHideCategory(false);
            model.getOperation().setCategory(null);
        } else {
            view.showHideCategory(true);
        }
        model.getOperation().setType(type);
    }

    public void setCategory(int position) {
        String categoryName = model.getCategoryList().get(position);
        Category category = Categories.get().getCategoryByName(categoryName);
        model.getOperation().setCategory(category);
    }

    public void initOperationType() {
        List<String> list = new ArrayList<>(Arrays.asList(new String[] { "Расход", "Доход" }));
        int selection = 0;
        view.initOperationType(list, selection);
    }

    public void initCurrency() {
        List<String> currencyList = model.getCurrencyList();
        int selection = 0;
        view.initCurrency(currencyList, selection);
    }

    public void initCategory() {
        List<String> currencyList = model.getCategoryList();
        int selection = 0;
        view.initCategory(currencyList, selection);
    }

    public void initDate() {
        view.setDate("Дата операции");
    }

    public void setCurrency(int position) {
        String currencyName = model.getCurrencyList().get(position);
        Currency currency = Currencies.get().getCurrencyByName(currencyName);
        model.getOperation().setCurrency(currency);
    }

    public void save() {
        if (!checkForSave()) {
            account.addOperation(model.getOperation());
            view.exitFromScreen();
        }
    }

    public boolean checkForSave() {
        boolean isError = false;

        // TODO: Проверить, что сумма была не слишком большой и чтобы больше нуля
        if (model.getOperation().getSum() <= 0) {
            view.showSumError(R.string.operation_creator_error_sum_empty);
            isError = true;
        }

        return isError;
    }
}