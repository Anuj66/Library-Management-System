package com.lms.demo.repository;

import java.util.List;
import java.util.Optional;

import com.lms.demo.model.Category;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,  String> {
    List<Category> findAll();
    Category save(Category category);
    Optional<Category> findById(String id);
    void delete(Category category);

    Category findByCategoryName(String categoryName);
}
