package ru.s4nchez.crackerfinance.utils;

public class MyLog {

    private static final String TAG = "sssss";

    public static void l(Object... objects) {
        StringBuilder message = new StringBuilder();
        for (Object obj : objects) {
            message.append(obj.toString());
            message.append(" ");
        }
        android.util.Log.d(TAG, message.toString().trim());
    }
}