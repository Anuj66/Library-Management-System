package com.lms.demo.repository;

import java.util.List;
import java.util.Optional;

import com.lms.demo.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findAll();
    User save(User user);
    Optional<User> findById(String id);
    void delete(User user);
    User findByEmail(String email);
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
