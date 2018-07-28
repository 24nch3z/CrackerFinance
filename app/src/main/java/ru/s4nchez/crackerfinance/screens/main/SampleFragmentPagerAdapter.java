package ru.s4nchez.crackerfinance.screens.main;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ru.s4nchez.crackerfinance.screens.general.GeneralInformationFragment;
import ru.s4nchez.crackerfinance.screens.list.OperationsListFragment;
import ru.s4nchez.crackerfinance.screens.page.PageFragment;
import ru.s4nchez.crackerfinance.utils.MyLog;
import ru.s4nchez.crackerfinance.utils.MyToast;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    // TODO: Сделать локализацию тайтлов
    private String tabTitles[] = new String[] { "Основное", "Операции" };

    public SampleFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
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
