package com.lms.demo.repository;

import com.lms.demo.model.Rented;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentedRepository extends MongoRepository<Rented, String> {

    List<Rented> findAll();

    Rented save(Rented rented);

    void deleteById(String id);

    void deleteByBook_IdAndUser_Id(String bookId, String userId);

    Rented findByBook_IdAndUser_Id(String bookId, String userId);

}
