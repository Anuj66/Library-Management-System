package com.lms.demo.controller;

import com.lms.demo.model.User;
import com.lms.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired UserService userService;

  // Get all Users
  @GetMapping("/")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<List<User>> getAllUsers() {
    return new ResponseEntity<>(userService.getAllUser(), HttpStatus.OK);
  }

  // Save a User
  @PostMapping("/")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<User> saveUser(@RequestBody User user) {
    return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
  }

  // Update a User
  @PutMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String id) {
    return new ResponseEntity<>(userService.updateUser(user, id), HttpStatus.OK);
  }

  // Delete a User
  @DeleteMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN')")
  public ResponseEntity<String> deleteUser(@PathVariable String id) {
    return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
  }

  // Get a User
  // TODO: Need to provide proper authentication - GetUserByID!
  @GetMapping("/{id}")
  @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
  public ResponseEntity getUser(@PathVariable String id) {
    return new ResponseEntity<>(userService.getUser(id), HttpStatus.OK);
  }
}
