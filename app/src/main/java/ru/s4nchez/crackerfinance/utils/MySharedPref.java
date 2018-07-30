package ru.s4nchez.crackerfinance.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharedPref {

    private static final String FILENAME = "sp";

    private static SharedPreferences.Editor editor(Context context) {
        SharedPreferences sp = context.getSharedPreferences(FILENAME, context.MODE_PRIVATE);
        return sp.edit();
    }

    public static void save(Context context, String name, boolean value) {
        SharedPreferences.Editor editor = editor(context);
        editor.putBoolean(name, value);
        editor.commit();
    }

    public static void save(Context context, String name, int value) {
        SharedPreferences.Editor editor = editor(context);
        editor.putInt(name, value);
        editor.commit();
    }

    public static void save(Context context, String name, String value) {
        SharedPreferences.Editor editor = editor(context);
        editor.putString(name, value);
        editor.commit();
    }

    public static boolean getBoolean(Context context, String name, boolean defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(FILENAME, context.MODE_PRIVATE);
        return sp.getBoolean(name, defaultValue);
    }

    public static int getInt(Context context, String name, int defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(FILENAME, context.MODE_PRIVATE);
        return sp.getInt(name, defaultValue);
    }

    public static String getString(Context context, String name, String defaultValue) {
        SharedPreferences sp = context.getSharedPreferences(FILENAME, context.MODE_PRIVATE);
        return sp.getString(name, defaultValue);
    }
}