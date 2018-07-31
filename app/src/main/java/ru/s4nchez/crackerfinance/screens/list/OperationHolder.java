package ru.s4nchez.crackerfinance.screens.list;

import android.support.v7.widget.RecyclerView;

import ru.s4nchez.crackerfinance.databinding.ItemOperationBinding;
import ru.s4nchez.crackerfinance.model.Operation;

public class OperationHolder extends RecyclerView.ViewHolder {

    private ItemOperationBinding binding;

    public OperationHolder(ItemOperationBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        this.binding.setViewModel(new OperationViewModel());
    }

    public void bind(Operation operation) {
        binding.getViewModel().setOperation(operation);
        binding.executePendingBindings();
    }
}