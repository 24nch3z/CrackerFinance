package ru.s4nchez.crackerfinance.screens.list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.ItemOperationBinding;
import ru.s4nchez.crackerfinance.model.Operation;
import ru.s4nchez.crackerfinance.vm.AppViewModel;

public class OperationAdapter extends RecyclerView.Adapter<OperationHolder> {

    private List<Operation> items;
    private Context context;

    public OperationAdapter(List<Operation> items, Context context) {
        this.items = items;
        this.context = context;
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
        holder.bind(operation);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}