package com.lms.demo.service.impl;

import java.util.List;

import com.lms.demo.exceptionHandler.ObjectAlreadyExists;
import com.lms.demo.exceptionHandler.ObjectDoNotExists;
import com.lms.demo.model.Category;
import com.lms.demo.repository.CategoryRepository;
import com.lms.demo.service.CategoryService;

import com.lms.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if (categories.isEmpty()) {
            throw new ObjectDoNotExists(Constants.CATEGORIES_NOT_FOUND);
        }
        return categories;
    }

    @Override
    public Category saveCategory(Category category) {
        Category categoryExist = categoryRepository.findByCategoryName(category.getCategoryName());
        if(categoryExist != null)
            throw new ObjectAlreadyExists(Constants.CATEGORY_ALREADY_EXISTS);
        Category savedCategory = categoryRepository.save(category);
        return savedCategory;
    }

    @Override
    public Category updateCategory(Category category, String id) {
        categoryRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.CATEGORY_NOT_EXISTS));
        category.setId(id);
        return categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(String id) {
        Category oldCategory = categoryRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.CATEGORY_NOT_EXISTS));
        categoryRepository.delete(oldCategory);
        return "Category Deleted Successfully";
    }

    @Override
    public Category getCategory(String id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.CATEGORY_NOT_EXISTS));
        return category;
    }

}
