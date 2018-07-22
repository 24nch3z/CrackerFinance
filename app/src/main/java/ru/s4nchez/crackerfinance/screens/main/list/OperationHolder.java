package ru.s4nchez.crackerfinance.screens.main.list;

import android.support.v7.widget.RecyclerView;

import ru.s4nchez.crackerfinance.databinding.ItemOperationBinding;
import ru.s4nchez.crackerfinance.model.Operation;

public class OperationHolder extends RecyclerView.ViewHolder {

    private ItemOperationBinding mBinding;

    public OperationHolder(ItemOperationBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
        mBinding.setViewModel(new OperationViewModel());
    }

    public void bind(Operation operation) {
        mBinding.getViewModel().setOperation(operation);
        mBinding.executePendingBindings();
    }
}