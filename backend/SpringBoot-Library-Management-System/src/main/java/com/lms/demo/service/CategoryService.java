package com.lms.demo.service;

import java.util.List;

import com.lms.demo.model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category saveCategory(Category category);
    Category updateCategory(Category category, String id);
    String deleteCategory(String id);
    Category getCategory(String id);
}
