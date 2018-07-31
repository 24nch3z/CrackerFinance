package ru.s4nchez.crackerfinance.screens.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.s4nchez.crackerfinance.R;

public class FragmentMainScreen extends Fragment {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.tabLayout)
    TabLayout tabLayout;

    private SampleFragmentPagerAdapter adapter;

    public static FragmentMainScreen newInstance() {
        return new FragmentMainScreen();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_screen, container, false);
        ButterKnife.bind(this, v);

        adapter = new SampleFragmentPagerAdapter(getChildFragmentManager(), getContext());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        initToolbar();

        return v;
    }

    private void initToolbar() {
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setTitle(getString(R.string.section_main));
    }
}