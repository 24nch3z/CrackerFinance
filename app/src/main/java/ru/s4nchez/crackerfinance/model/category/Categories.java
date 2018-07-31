package ru.s4nchez.crackerfinance.model.category;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private static Categories instance;

    private List<Category> categories;

    private Category products = new Category("products", "Продукты");
    private Category clothes = new Category("clothes", "Одежда");

    private Categories() {
        categories = new ArrayList<>();
        categories.add(products);
        categories.add(clothes);
    }

    public static Categories get() {
        if (instance == null) {
            instance = new Categories();
        }
        return instance;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category products() {
        return products;
    }

    public Category clothes() {
        return clothes;
    }
}
