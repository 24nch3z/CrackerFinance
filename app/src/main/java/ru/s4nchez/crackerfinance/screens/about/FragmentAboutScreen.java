package ru.s4nchez.crackerfinance.screens.about;

import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.FragmentAboutScreenBinding;

public class FragmentAboutScreen extends Fragment {

    public static FragmentAboutScreen newInstance() {
        FragmentAboutScreen fragment = new FragmentAboutScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentAboutScreenBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_about_screen, container, false);

        String versionName = null;
        try {
            versionName = getActivity().getPackageManager()
                    .getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        // TODO: Вынести в строки
        if (versionName != null) {
            binding.version.setText( "Версия приложения: " + versionName);
        }

        return binding.getRoot();
    }
}