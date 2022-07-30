package com.lms.demo.repository;

import com.lms.demo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> findAll();

    Optional<Book> findById(String id);

    Book save(Book book);

    Book findByName(String name);

    void deleteById(String id);

}
