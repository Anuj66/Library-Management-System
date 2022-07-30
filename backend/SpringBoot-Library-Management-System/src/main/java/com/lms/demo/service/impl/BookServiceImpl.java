package com.lms.demo.service.impl;

import com.lms.demo.exceptionHandler.ObjectAlreadyExists;
import com.lms.demo.exceptionHandler.ObjectDoNotExists;
import com.lms.demo.model.Book;
import com.lms.demo.repository.BookRepository;
import com.lms.demo.service.BookService;
import com.lms.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        if(books.isEmpty()){
            throw new ObjectDoNotExists(Constants.BOOKS_NOT_FOUND);
        }
        return books;
    }

    @Override
    public Book findById(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.BOOK_NOT_EXISTS));
    }

    @Override
    public Book save(Book book) {
        Book bookExists = bookRepository.findByName(book.getName());
        if(bookExists != null) {
            throw new ObjectAlreadyExists(Constants.BOOK_ALREADY_EXISTS);
        }
        return bookRepository.save(book);
    }

    @Override
    public Book update(Book book, String id) {
        bookRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.BOOK_NOT_EXISTS));
        book.setId(id);
        return bookRepository.save(book);
    }

    @Override
    public String delete(String id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.BOOK_NOT_EXISTS));
        bookRepository.delete(book);
        return "Book Deleted Successfully";
    }
}
