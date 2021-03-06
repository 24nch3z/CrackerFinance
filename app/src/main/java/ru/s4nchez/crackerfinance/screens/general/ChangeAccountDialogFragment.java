package ru.s4nchez.crackerfinance.screens.general;

import android.app.Dialog;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;

import java.util.List;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.vm.AppViewModel;

public class ChangeAccountDialogFragment extends DialogFragment {

    public static ChangeAccountDialogFragment newInstance() {
        return new ChangeAccountDialogFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AppViewModel viewModel = ViewModelProviders
                .of(getActivity()).get(AppViewModel.class);
        List<String> list = viewModel.getBank().getAccountsNames();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, list);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        return new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.main_screen_dialog_title))
                .setPositiveButton(getString(R.string.main_screen_dialog_positive_button), null)
                .setAdapter(adapter, (dialogInterface, i) -> viewModel.setCurrentAccount(i))
                .create();
    }
}
