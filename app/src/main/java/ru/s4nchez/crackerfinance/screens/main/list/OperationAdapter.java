package ru.s4nchez.crackerfinance.screens.main.list;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.ItemOperationBinding;
import ru.s4nchez.crackerfinance.model.Operation;

public class OperationAdapter extends RecyclerView.Adapter<OperationHolder> {

    private List<Operation> mItems;
    private Context mContext;

    public OperationAdapter(List<Operation> items, Context context) {
        mItems = items;
        mContext = context;
    }

    @Override
    public OperationHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext.getApplicationContext());
        ItemOperationBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.item_operation, parent, false);
        return new OperationHolder(binding);
    }

    @Override
    public void onBindViewHolder(OperationHolder holder, int position) {
        Operation operation = mItems.get(position);
        holder.bind(operation);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}