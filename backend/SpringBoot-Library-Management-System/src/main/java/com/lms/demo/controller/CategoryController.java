package com.lms.demo.controller;

import com.lms.demo.model.Category;
import com.lms.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

  @Autowired CategoryService categoryService;

  // Get All Categories
  @GetMapping("/")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR') or hasRole('USER')")
  public ResponseEntity<List<Category>> getAllCategories() {
    return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
  }

  // Save a category
  @PostMapping("/")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
  public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
    return new ResponseEntity<>(categoryService.saveCategory(category), HttpStatus.OK);
  }

  // Update a category
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
  public ResponseEntity<Category> updateCategory(
      @RequestBody Category category, @PathVariable String id) {
    return new ResponseEntity<>(categoryService.updateCategory(category, id), HttpStatus.OK);
  }

  // Delete a category
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
  public ResponseEntity<String> deleteCategory(@PathVariable String id) {
    return new ResponseEntity<>(categoryService.deleteCategory(id), HttpStatus.OK);
  }

  // Get a category
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR') or hasRole('USER')")
  public ResponseEntity<Category> getCategory(@PathVariable String id) {
    return new ResponseEntity<>(categoryService.getCategory(id), HttpStatus.OK);
  }
}
