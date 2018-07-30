package ru.s4nchez.crackerfinance.screens.operation;

import java.util.Date;
import java.util.List;

import ru.s4nchez.crackerfinance.model.Operation;
import ru.s4nchez.crackerfinance.model.OperationType;
import ru.s4nchez.crackerfinance.model.category.Categories;
import ru.s4nchez.crackerfinance.model.currency.Currencies;

public class OperationCreatorModel {

    private Operation operation;
    private List<String> currencyList;
    private List<String> categoryList;

    public OperationCreatorModel() {
        initOperation();
        currencyList = Currencies.get().getCurrencyNames();
        categoryList = Categories.get().getCategoriesNames();
        operation.setCreatingDate(new Date());
        operation.setOperationDate(new Date());
    }

    private void initOperation() {
        operation = new Operation();
        operation.setType(OperationType.income);
        operation.setCurrency(Currencies.get().ruble());
        operation.setSum(0.0);
        operation.setCategory(Categories.get().products());
    }

    public Operation getOperation() {
        return operation;
    }

    public List<String> getCurrencyList() {
        return currencyList;
    }

    public List<String> getCategoryList() {
        return categoryList;
    }
}