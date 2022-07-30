package com.lms.demo.service;

import java.util.List;

import com.lms.demo.model.User;

public interface UserService {
    List<User> getAllUser(); 
    User save(User user);
    User updateUser(User user, String id);
    String deleteUser(String id);
    User getUser(String id);
}
