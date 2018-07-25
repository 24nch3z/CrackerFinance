package ru.s4nchez.crackerfinance;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import ru.s4nchez.crackerfinance.screens.about.FragmentAboutScreen;
import ru.s4nchez.crackerfinance.screens.main.FragmentMainScreen;
import ru.s4nchez.crackerfinance.screens.settings.FragmentSettingsScreen;
import ru.s4nchez.crackerfinance.utils.MyToast;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            MyApplication.instance.getRouter().replaceScreen(Screens.SCREEN_MAIN);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MyApplication.instance.getNavigatorHolder().setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MyApplication.instance.getNavigatorHolder().removeNavigator();
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(),
            R.id.container) {
        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            getSupportActionBar().setTitle(screenKey);
            switch(screenKey) {
                case Screens.SCREEN_MAIN:
                    setToolbarText(getString(R.string.section_main));
                    return FragmentMainScreen.newInstance();
                case Screens.SCREEN_ABOUT:
                    setToolbarText(getString(R.string.section_about));
                    return FragmentAboutScreen.newInstance();
                case Screens.SCREEN_SETTINGS:
                    setToolbarText(getString(R.string.section_settings));
                    return FragmentSettingsScreen.newInstance();
                default:
                    return FragmentMainScreen.newInstance();
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            MyToast.get(MainActivity.this).show(message);
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_main) {
            MyApplication.instance.getRouter().replaceScreen(Screens.SCREEN_MAIN);
        } else if (id == R.id.nav_settings) {
            MyApplication.instance.getRouter().replaceScreen(Screens.SCREEN_SETTINGS);
        } else if (id == R.id.nav_about) {
            MyApplication.instance.getRouter().replaceScreen(Screens.SCREEN_ABOUT);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setToolbarText(String message) {
        toolbar.setTitle(message);
    }
}