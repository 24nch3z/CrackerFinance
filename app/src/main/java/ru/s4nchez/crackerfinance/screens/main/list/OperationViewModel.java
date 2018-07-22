package ru.s4nchez.crackerfinance.screens.main.list;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ru.s4nchez.crackerfinance.model.Operation;

public class OperationViewModel extends BaseObservable {

    private Operation mOperation;

    @Bindable
    public Operation getOperation() {
        return mOperation;
    }

    public void setOperation(Operation operation) {
        mOperation = operation;
        notifyChange();
    }
}