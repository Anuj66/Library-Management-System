package com.lms.demo.controller;

import com.lms.demo.model.Rented;
import com.lms.demo.service.RentedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rented/")
public class RentedController {

  @Autowired RentedService rentedService;

  @GetMapping
  public ResponseEntity<List<Rented>> getAllEntries(){
    return new ResponseEntity<>(rentedService.getAllRentedEntries(), HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Rented> save(@RequestBody Rented rented) {
    return new ResponseEntity<>(rentedService.save(rented), HttpStatus.OK);
  }

}
