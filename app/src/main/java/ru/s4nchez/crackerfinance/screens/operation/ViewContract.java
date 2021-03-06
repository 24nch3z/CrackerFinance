package ru.s4nchez.crackerfinance.screens.operation;

import java.util.List;

public interface ViewContract {
    void setSum(String s);

    void setComment(String s);

    void initOperationType(List<String> list, int selection);

    void initCurrency(List<String> list, int selection);

    void initCategory(List<String> list, int selection);

    void exitFromScreen();

    void showSumError(int textErrorId);

    void showHideCategory(boolean flag);
}
