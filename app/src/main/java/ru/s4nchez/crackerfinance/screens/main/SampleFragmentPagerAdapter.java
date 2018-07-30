package ru.s4nchez.crackerfinance.screens.main;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.s4nchez.crackerfinance.R;
import ru.s4nchez.crackerfinance.screens.general.GeneralInformationFragment;
import ru.s4nchez.crackerfinance.screens.list.OperationsListFragment;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;

    private String tabTitles[];

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        tabTitles = new String[]{
                context.getString(R.string.main_screen_tab_main),
                context.getString(R.string.main_screen_tab_operations)
        };
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return GeneralInformationFragment.newInstance();
            case 1:
                return OperationsListFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
