package ru.s4nchez.crackerfinance;

public abstract class BasePresenter<T> {

    protected T view;

    public void attachView(T view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }
}
