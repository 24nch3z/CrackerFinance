package ru.s4nchez.crackerfinance;

import android.app.Application;

import ru.s4nchez.crackerfinance.model.Repository;
import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class MyApplication extends Application {

    public static MyApplication instance;

    private Cicerone<Router> cicerone;
    private Repository repository;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        cicerone = Cicerone.create();
        repository = new Repository();
    }

    public NavigatorHolder getNavigatorHolder() {
        return cicerone.getNavigatorHolder();
    }

    public Router getRouter() {
        return cicerone.getRouter();
    }

    public Repository getRepository() {
        return repository;
    }
}