package ru.s4nchez.crackerfinance;

import android.support.v4.app.Fragment;

import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    protected Unbinder butterKnifeUnbinder;

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnifeUnbinder.unbind();
    }
}