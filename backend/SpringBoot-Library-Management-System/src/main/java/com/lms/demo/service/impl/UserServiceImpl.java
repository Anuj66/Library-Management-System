package com.lms.demo.service.impl;

import java.util.List;

import com.lms.demo.exceptionHandler.ObjectAlreadyExists;
import com.lms.demo.exceptionHandler.ObjectDoNotExists;
import com.lms.demo.model.User;
import com.lms.demo.repository.UserRepository;
import com.lms.demo.service.UserService;

import com.lms.demo.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty()){
            throw new ObjectDoNotExists(Constants.CUSTOMERS_NOT_FOUND);
        }
        return userList;
    }

    @Override
    public User save(User user) {
        User userExist = userRepository.findByEmail(user.getEmail());
        if(userExist != null)
            throw new ObjectAlreadyExists(Constants.CUSTOMER_ALREADY_EXISTS);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, String id) {
        userRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.CUSTOMER_NOT_EXISTS));
        // todo : Need to add some more validations
        user.setId(id);
        return userRepository.save(user);
    }

    @Override
    public String deleteUser(String id) {
        User oldUser = userRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.CUSTOMER_NOT_EXISTS));
        userRepository.delete(oldUser);
        return "User Deleted Successfully";
    }

    @Override
    public User getUser(String id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectDoNotExists(Constants.CUSTOMER_NOT_EXISTS));
    }

}
