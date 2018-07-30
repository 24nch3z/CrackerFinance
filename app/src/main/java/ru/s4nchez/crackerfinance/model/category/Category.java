package ru.s4nchez.crackerfinance.model.category;

public class Category {

    final private String id;
    final private String name;

    public Category(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
