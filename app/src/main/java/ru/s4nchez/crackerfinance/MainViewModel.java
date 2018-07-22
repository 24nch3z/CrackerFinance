package ru.s4nchez.crackerfinance;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ru.s4nchez.crackerfinance.databinding.ActivityMainBinding;
import ru.s4nchez.crackerfinance.screens.main.FragmentMainScreen;
import ru.s4nchez.crackerfinance.screens.settings.FragmentSettingsScreen;

public class MainViewModel extends BaseObservable {

    private Activity mActivity;
    private ActivityMainBinding mBinding;

    public MainViewModel(Activity activity, ActivityMainBinding binding) {
        mActivity = activity;
        mBinding = binding;
    }

    public boolean onBackPressed() {
        if (mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            mBinding.drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }
}