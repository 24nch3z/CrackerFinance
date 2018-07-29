package ru.s4nchez.crackerfinance.screens.list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.AppViewModel;
import ru.s4nchez.crackerfinance.databinding.ItemOperationBinding;
import ru.s4nchez.crackerfinance.model.Operation;

public class OperationAdapter extends RecyclerView.Adapter<OperationHolder> {

    private List<Operation> items;
    private Context context;
    private AppViewModel viewModel;

    public OperationAdapter(List<Operation> items, Context context, AppViewModel viewModel) {
        this.items = items;
        this.context = context;
        this.viewModel = viewModel;
    }

    public void setItems(List<Operation> items) {
        this.items = items;
    }

    @Override
    public OperationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        ItemOperationBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.item_operation, parent, false);
        return new OperationHolder(binding);
    }

    @Override
    public void onBindViewHolder(OperationHolder holder, int position) {
        Operation operation = items.get(position);
        holder.bind(operation, position, viewModel);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}