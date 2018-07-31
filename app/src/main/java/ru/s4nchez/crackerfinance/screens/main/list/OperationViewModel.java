package ru.s4nchez.crackerfinance.screens.main.list;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ru.s4nchez.crackerfinance.model.Operation;

public class OperationViewModel extends BaseObservable {

    private Operation operation;

    @Bindable
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
        notifyChange();
    }
}