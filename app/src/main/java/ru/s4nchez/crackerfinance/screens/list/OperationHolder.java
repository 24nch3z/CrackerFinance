package ru.s4nchez.crackerfinance.screens.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import ru.s4nchez.crackerfinance.vm.AppViewModel;
import ru.s4nchez.crackerfinance.databinding.ItemOperationBinding;
import ru.s4nchez.crackerfinance.model.Operation;
import ru.s4nchez.crackerfinance.utils.MyToast;

public class OperationHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

    private AppViewModel viewModel;
    private ItemOperationBinding binding;
    private int position = -1;

    public OperationHolder(ItemOperationBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
        this.binding.setViewModel(new OperationViewModel());
        binding.getRoot().setOnLongClickListener(this);
    }

    public void bind(Operation operation, int position, AppViewModel viewModel) {
        this.position = position;
        this.viewModel = viewModel;
        binding.getViewModel().setOperation(operation);
        binding.executePendingBindings();
    }

    @Override
    public boolean onLongClick(View view) {
        viewModel.removeOperation(position);
        MyToast.get(view.getContext()).show("Опаньки");
        return true;
    }
}