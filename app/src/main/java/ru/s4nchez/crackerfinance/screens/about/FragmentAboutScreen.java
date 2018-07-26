package ru.s4nchez.crackerfinance.screens.about;

import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.databinding.FragmentAboutScreenBinding;

public class FragmentAboutScreen extends Fragment {

    private TextView textViewVersion;

    public static FragmentAboutScreen newInstance() {
        FragmentAboutScreen fragment = new FragmentAboutScreen();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_about_screen, container, false);
        textViewVersion = v.findViewById(R.id.version);
        setVersion();
        return v;
    }

    private void setVersion() {
        String versionName = null;

        try {
            versionName = getActivity().getPackageManager()
                    .getPackageInfo(getActivity().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        if (versionName != null) {
            textViewVersion.setText(getText(R.string.about_screen_version) + " " + versionName);
        }
    }
}