package ru.s4nchez.crackerfinance.model.category;

import java.util.ArrayList;
import java.util.List;

public class Categories {

    private static Categories instance;

    private List<Category> categories;

    private Category other = new Category("other", "Другое");
    private Category products = new Category("products", "Продукты");
    private Category clothes = new Category("clothes", "Одежда");
    private Category communal = new Category("communal", "Коммунальные платежи");
    private Category entertainment = new Category("entertainment", "Развлечения");

    private Categories() {
        categories = new ArrayList<>();
        categories.add(other);
        categories.add(products);
        categories.add(clothes);
        categories.add(communal);
        categories.add(entertainment);
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

    public List<String> getCategoriesNames() {
        List<String> labels = new ArrayList<>(categories.size());
        for (Category c : categories) {
            labels.add(c.getName());
        }
        return labels;
    }

    public Category getCategoryByName(String name) {
        for (Category category : categories) {
            if (name.equalsIgnoreCase(category.getName())) {
                return category;
            }
        }
        return null;
    }

    public Category products() {
        return products;
    }

    public Category clothes() {
        return clothes;
    }

    public Category other() {
        return other;
    }

    public Category communal() {
        return communal;
    }

    public Category entertainment() {
        return entertainment;
    }
}