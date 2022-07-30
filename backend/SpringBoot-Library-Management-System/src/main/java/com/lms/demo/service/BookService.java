package com.lms.demo.service;

import com.lms.demo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAllBooks();

    Book findById(String id);

    Book save(Book book);

    Book update(Book book, String id);

    String delete(String id);

}
